package com.rsh_engineering.tkachenkoni.checkpressurelist.billing

import android.app.Activity
import android.text.TextUtils
import android.util.Log
import com.android.billingclient.api.*
import com.rsh_engineering.tkachenkoni.checkpressurelist.presentation.utils.PrefUtils
import java.util.*
import kotlin.collections.HashMap

/**
 *
 * Created by Nikolay Tkachenko on 07, June, 2021
 *
 */
class BillingAgentV2(
    val activity: Activity?,
    val callback: BillingCallback?
): PurchasesUpdatedListener {

    private var billingClient: BillingClient? = null
    private var productsSKUList: ArrayList<String>? = null

    private val key_product = "health_human_ads"

    private var skuDetailsMap = HashMap<String, SkuDetails>()


    init {
        billingClient = BillingClient
            .newBuilder(activity!!)
            .setListener(this)
            .enablePendingPurchases()
            .build()
        productsSKUList = ArrayList<String>()
        productsSKUList!!.add(key_product)

        //создаем обеъект платежного клиента с механизмами когда подключаемся к платежной система


        //создаем обеъект платежного клиента с механизмами когда подключаемся к платежной система
        billingClient!!.startConnection(object : BillingClientStateListener {
            override fun onBillingSetupFinished(billingResult: BillingResult) {
                //сюда попадаем , когда выполненна настройка платежного клиета
                //здесь запрашиваем информацию о оварах и покупках
                if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
                    //Когда платежная система доступна
                    //Можем делать запрос о товарах
                    querySkuDetails()

                    //Выполняем запрос о уже осуществденных покупках
                    requestPurchased()
                }
            }

            override fun onBillingServiceDisconnected() {
                //здесб обработаем ошибки , и поподаем сюда, когда что-то пойдет не так
            }
        })
    }


    //Метод, который выполняет запрос о уже осуществленных покупках
    private fun requestPurchased() {
        Log.d("BILLING_ACTION", "requestPurchased()")
        val purchaseList = queryPurchasesINAPP()
        Log.d("BILLING_ACTION", "purchaseList.size = " + purchaseList!!.size)
        //если товар уже куплен, то предоставить его пользователю
        for (i in purchaseList.indices) {
            val purchaseId = purchaseList[i].sku
            if (TextUtils.equals(key_product, purchaseId)) {
                Log.d("BILLING_ACTION", "TextUtils.equals(key_product, purchaseId)")
                payCompleted()
            }
        }
    }

    private fun queryPurchasesINAPP(): List<Purchase>? {
        Log.d("BILLING_ACTION", "queryPurchasesINAPP()")
        val purchasesResult = billingClient!!.queryPurchases(BillingClient.SkuType.INAPP)
        return purchasesResult.purchasesList
    }


    override fun onPurchasesUpdated(
        billingResult: BillingResult,
        purchaseList: MutableList<Purchase>?
    ) {
        Log.d("BILLING_ACTION", "onPurchasesUpdated")
        //сюда попадаем, когда будет осуществлена покупка
        //сюда попадаем, когда будет осуществлена покупка
        if (billingResult.responseCode == BillingClient.BillingResponseCode.OK
            && purchaseList != null
        ) {
            for (i in purchaseList.indices) {
                val purchaseId = purchaseList[i].sku
                if (TextUtils.equals(key_product, purchaseId)) {
                    PrefUtils.getInstance(activity)!!.saveTokenPurchase(purchaseList[i].purchaseToken)
                    payCompleted()
                }
            }
        } else {
            //обрабатываем ответ по коду , что получили от платежной системы
            Log.d(
                "BILLING_ACTION",
                "billingResult.getResponseCode() = " + billingResult.responseCode
            )
            when (billingResult.responseCode) {
                BillingClient.BillingResponseCode.ITEM_ALREADY_OWNED -> Log.d(
                    "BILLING_ACTION",
                    "ITEM_ALREADY_OWNED"
                )
                BillingClient.BillingResponseCode.BILLING_UNAVAILABLE -> Log.d(
                    "BILLING_ACTION",
                    "BILLING_UNAVAILABLE"
                )
                BillingClient.BillingResponseCode.DEVELOPER_ERROR -> Log.d(
                    "BILLING_ACTION",
                    "DEVELOPER_ERROR"
                )
                BillingClient.BillingResponseCode.ERROR -> Log.d("BILLING_ACTION", "ERROR")
                BillingClient.BillingResponseCode.ITEM_NOT_OWNED -> Log.d(
                    "BILLING_ACTION",
                    "ITEM_NOT_OWNED"
                )
                BillingClient.BillingResponseCode.ITEM_UNAVAILABLE -> Log.d(
                    "BILLING_ACTION",
                    "ITEM_UNAVAILABLE"
                )
                BillingClient.BillingResponseCode.SERVICE_DISCONNECTED -> Log.d(
                    "BILLING_ACTION",
                    "SERVICE_DISCONNECTED"
                )
                BillingClient.BillingResponseCode.SERVICE_TIMEOUT -> Log.d(
                    "BILLING_ACTION",
                    "SERVICE_TIMEOUT"
                )
                BillingClient.BillingResponseCode.SERVICE_UNAVAILABLE -> Log.d(
                    "BILLING_ACTION",
                    "SERVICE_UNAVAILABLE"
                )
                BillingClient.BillingResponseCode.USER_CANCELED -> Log.d(
                    "BILLING_ACTION",
                    "USER_CANCELED"
                )
                BillingClient.BillingResponseCode.FEATURE_NOT_SUPPORTED -> Log.d(
                    "BILLING_ACTION",
                    "FEATURE_NOT_SUPPORTED"
                )
            }
        }
    }

    //этот иметод вызывается когда покупка осуществлена
    private fun payCompleted() {
        Log.d("BILLING_ACTION", "payComplete()")
        PrefUtils.getInstance(activity)!!.setMarkPurchased(true)
        callback!!.onTokenConsumed()
    }


    //Запрос на получение товаров для полкупки
    private fun querySkuDetails() {
        Log.d("BILLING_ACTION", "querySkuDetails()")
        val skuDetailsParamsBuilder = SkuDetailsParams.newBuilder()
        productsSKUList?.let {
            skuDetailsParamsBuilder.setSkusList(it).setType(BillingClient.SkuType.INAPP)
            billingClient!!.querySkuDetailsAsync(
                skuDetailsParamsBuilder.build()
            ) { billingResult, list ->
                //получаем список товаров доступных для покупки
                if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
                    list?.let {
                        for (skuDetails in list) {
                            skuDetailsMap.put(skuDetails.sku, skuDetails)
                        }
                    }


                    //выводим в лог описание полученных товаров
                    showSkuDetails()
                }
            }
        }
    }


    //покупка одного товара
    fun purshaseView() {
        Log.d("BILLING_ACTION", "purshaseView()")
        launchBilling(key_product)
    }


    //метод, клторый вызывается при осуществлении покупки
    fun launchBilling(skuId: String) {
        try {
            Log.d("BILLING_ACTION", "launchBilling")
            Log.d("BILLING_ACTION", "skuId = $skuId")
            val billingFlowParams = BillingFlowParams
                .newBuilder()
                .setSkuDetails(skuDetailsMap.get(key_product)!!)
                .build()
            billingClient!!.launchBillingFlow(activity!!, billingFlowParams)
        } catch (e: Exception) {
            e.printStackTrace()
            Log.d("BILLING_ACTION", "e = " + e.message)
        }
    }


    //обнуляем платежный клиент, когда закрвается активити
    fun onDestroy() {
        if (billingClient != null) {
            billingClient!!.endConnection()
            billingClient = null
        }
    }

    private fun showSkuDetails() {
        for ((key, value) in skuDetailsMap.entries) {
            Log.d("BILLING_ACTION", "item.getKey() = $key")
            Log.d("BILLING_ACTION", "item.getDescription() = " + value.description)
            Log.d("BILLING_ACTION", "item.getSku() = " + value.sku)
            Log.d("BILLING_ACTION", "item.getType() = " + value.type)
            Log.d("BILLING_ACTION", "item.getPrice()) = " + value.price)
            Log.d(
                "BILLING_ACTION",
                "item.getIntroductoryPricePeriod()) = " + value.introductoryPricePeriod
            )
            Log.d("BILLING_ACTION", "item.getOriginalJson()) = " + value.originalJson)
            Log.d("BILLING_ACTION", "item.getTitle()) = " + value.title)
        }
    }
}