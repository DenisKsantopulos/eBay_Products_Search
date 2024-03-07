package com.example.onlinestore.api

import retrofit2.Call
import com.example.onlinestore.models.Item
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface EbayApi {
    @Headers(
        "Accept: application/json",
        "Authorization:Bearer v^1.1#i^1#p^1#f^0#r^0#I^3#t^H4sIAAAAAAAAAOVYbWwURRi+6wdNBRT5EhuIx1L8QbN7s3t3e3dr7+ToFdq09MpdQWiCzX7MtmvvdpedOdqTkJ7lG4IxRoxQf6DxR5MaITHiR5AgflQJRv4YYhDiBwEJaSUSUxJD4+7dUa6VANJLbOL9uczMO+88z/O+78zsgPS08mU763aOzLSXFR1Og3SR3U5PB+XTSqseLS6qKLWBPAP74XRluqS3+LdqxCfiOheFSNdUBB3dibiKuExngEgaKqfxSEGcyicg4rDIxUKrGzmGApxuaFgTtTjhqA8HCFnyewWfzIqi1+umgd/sVW/7bNEChEsUJQF43MDnpV0+QTLHEUrCehVhXsUBggGMmwQuEnhbaBcHPBxgKRdgWgnHOmggRVNNEwoQwQxcLjPXyMN6b6g8QtDAphMiWB9aGYuE6sO1TS3VzjxfwZwOMczjJBrfqtEk6FjHx5Pw3sugjDUXS4oiRIhwBrMrjHfKhW6DeQj4Gal5mvEKbtrvhrTAyD6hIFKu1IwEj++Nw+pRJFLOmHJQxQpO3U9RUw3hBSjiXKvJdFEfdlh/a5J8XJEVaASI2hWhDaHmZiIYhqqCGhBPRtS4osIYJpujYRLykPd4GNpD8qyfhzIQcgtlveVknrBSjaZKiiUacjRpeAU0UcPx2jCcJ08b0yiiRoyQjC1E+XaenIaMn221gpqNYhJ3qFZcYcIUwpFp3j8CY7MxNhQhieGYh4kDGYnMWOu6IhETBzO5mEufbhQgOjDWOaezq6uL6nJRmtHuZACgnetXN8bEDpjgCdPWqvWsvXL/CaSSoSJCcyZSOJzSTSzdZq6aANR2Iuj2AzMBc7qPhxWc2PuPjjzOzvEVUagKEVmzQPw8AxnJB3ifpxAVEswlqdPCAQU+RSZ4oxNiPc6LkBTNPEsmoKFInMsjMy6fDEmJ9cuk2y/LpOCRWJKWIQQQCoLo9/2fCuVBUz0GRQPiguR6wfJ806bNYb2drVkfxfUw6U6u6XJHo5vCOrumVqllGxtQd6y1qspIOJnawINWw13J18QVU5kWc/1CCGDVeuFEqNMQhtKk6MVETYfNWlwRU1MrwC5DauYNnIrBuFlH7ZMiGdL1+sLs1QWj9y+3iYfjXbgz6j86n+7KClkpO7VYWfOR6YDXFco6gShRSzitWtd48/phdbdlUE+Kt2LeXKcUa5Nklq0iZa+cVIYuhTaLlAGRljTM2zYVsW5gLVonVM3zDBtaPA6NdfSk6zmRSGJeiMOpVtgFSHCFn2KHLe0Ffh/NegE7KV5i5ihtm2pbUiG24pJVD3mtdo7/yA/aMj+6134K9NpPFNntoBospZeAxdOK15YUz6hACoaUwssUUtpV89vVgFQnTOm8YhTNsf3x9oG6morayOvLtrSkzvYN2mbkvTEc3ggWjL0ylBfT0/OeHMDCOyOl9GNPzGTcwAW8tAt4ANsKltwZLaHnl8y9WmRPaP2vLOhgho9tPj+4/605x/eBmWNGdnupraTXbts4KM/WrlTcEIbKv6w5+fHa/sHU5R86Lz09svRcDzGLCh59+XjwTPT0ITh3y/TRC3v6n1x45pmOd3d/7vtr/sVPr7/XeES88mtP+vsjz3f2VM6+tqHhSPfW06NcQDse7usf+KrttYO/L/qzfeFzlYNn2a+79/qFvSeryy6sZStv3dy9smy4D80bePxVaduGHT+dq6jbevGR70beX3Wj7OTloqFjByuGluOB3ZGDxvLRpm07hJvt0RfTxYu2f/ZJ8FDP4qdubf3oavLEB+807Lv+49A3tr7mPdvf7Nn1oay9RNnOO7/on7e97OcQON984Gjj6Ky2Jv3ZS6u4a6cGqoff+OXbYUDu6h6pqkkzK7Kx/BuB1LNR/REAAA==",
        "Content-Type: application/json",
        "X-EBAY-C-MARKETPLACE-ID: EBAY_US"
    )
    @GET("buy/browse/v1/item_summary/search")
    fun findEbayItem(@Query("q") item: String,
                     @Query("offset") offsetNum: Int,
                     @Query("filter") filterName: String)
    : Call<Item>
}