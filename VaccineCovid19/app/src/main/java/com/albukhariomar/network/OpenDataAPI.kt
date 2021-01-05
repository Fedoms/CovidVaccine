package com.albukhariomar.network

import retrofit2.Retrofit
import retrofit2.http.GET

//Network Layer to comunicate with the Server


private const val BASE_URL = "https://raw.githubusercontent.com/italia"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .build()

interface OpenDataAPI {

    @GET("covid19-opendata-vaccini/master/dati/consegne-vaccini-latest.json")
    // dati sul totale delle consegne giornaliere dei vaccini suddivise per regioni.
    fun getDeliveredTodayInStates()

    @GET("covid19-opendata-vaccini/master/dati/vaccini-summary-latest.json")
    //dati sul totale delle consegne e somministrazioni avvenute sino ad oggi, includendo la percentuale di dosi somministrate (sul totale delle dosi consegnate) suddivise per regioni.
    fun getTillTodaySomministrationAndDeliveredinStates()

    @GET("covid19-opendata-vaccini/master/dati/somministrazioni-vaccini-latest.json")
    // dati sulle somministrazioni giornaliere dei vaccini suddivisi per regioni, fasce d'età e categorie di appartenenza dei soggetti vaccinati
    fun getDailySomministrationForState()

    @GET("covid19-opendata-vaccini/master/dati/somministrazioni-vaccini-summary-latest.json")
    //dati sul totale delle somministrazioni giornaliere per regioni e categorie di appartenenza dei soggetti vaccinati.
    fun getDailyVaccinatedPeopleForStates()


    @GET("covid19-opendata-vaccini/master/dati/punti-somministrazione-latest.json")
    // punti di somministrazione per ciascuna Regione e Provincia Autonoma.
    fun getSomministrationPointsForEveryone()


    @GET("covid19-opendata-vaccini/master/dati/anagrafica-vaccini-summary-latest.json")
    //totali delle somministrazioni per fasce d'età.
    fun getSomministrationForAge()

    @GET("covid19-opendata-vaccini/master/dati/last-update-dataset.json")
    //data e ora di ultimo aggiornamento del dataset.
    fun getTimeLastUpdateDataset()

}

object VaccineAPI {
    val retrofitService: OpenDataAPI by lazy {
        retrofit.create(OpenDataAPI::class.java)
    }
}

