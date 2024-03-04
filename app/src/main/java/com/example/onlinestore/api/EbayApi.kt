package com.example.onlinestore.api

import android.telecom.Call
import com.example.onlinestore.models.Item
import com.example.onlinestore.models.Items
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface EbayApi {
    @Headers(
        "Accept: application/json",
        "Authorization:Bearer v^1.1#i^1#r^0#I^3#f^0#p^1#t^H4sIAAAAAAAAAOVYf2wTVRxfuw6Z20CQMF0Q6/FDZbn2Xe9a1stWLWthDYNua1mgEcfr3es4aO9u996xNVMyFiRA0JioEJVfAYUQQvAHCWqQqBgJURP4y4RoQIgOAyayGIcK6F1bRjcJIGviEvtP8977vu/7fD7v+33fdw/0jCmdta5h3UCF5T7rzh7QY7VYmDJQOqakelyxtaqkCOQZWHb2TO+x9RZfqMUwlVT5FoRVRcbI3pVKypjPdNZRuibzCsQS5mWYQpgnAh/xL2jkXQ7Aq5pCFEFJUvZQoI6CjFdAIidybpfX7Ra9Rq98w2dUqaM4BsHZnEsErOARRY4zxjHWUUjGBMqkjnIBF0cDlgZclOF4juWB18F4uBhlb0UalhTZMHEAypeBy2fmanlYbw8VYow0YjihfCH/3EjYHwoEF0ZrnXm+fDkdIgQSHQ9t1SsisrfCpI5uvwzOWPMRXRAQxpTTl11hqFPefwPMPcDPSM0moBivqXG7Eh4h4WZAQaScq2gpSG6Pw+yRRDqRMeWRTCSSvpOihhrxFUggudZCw0UoYDf/mnWYlBIS0uqo4Bz/En9TE+ULIFnC8zGkw3JSklGE0E0tARpBBN1uF+OmoccLUQLEcwtlveVkHrZSvSKLkikati9UyBxkoEbDtWHztDGMwnJY8yeIiSjfzjOoIYiZm5rdRZ0sl819RSlDCHumeecdGJxNiCbFdYIGPQwfyEhkpJWqSiI1fDATi7nw6cJ11HJCVN7p7OzsdHSyDkVrd7oAYJyLFzRGhOUoBSnD1sz1rL105wm0lKEiIGMmlniSVg0sXUasGgDkdsrHeQHHeHO6D4XlG977j448zs6hGVGwDHHVuNjZXsiybiB64wXJEF8uSJ0mDhSHaToFtZWIqEkoIFow4kxPIU0SedadcLE1CUSLHm+C5ryJBB13ix6aSSAEEIrHBW/N/ylR7jbUI0jQEClIrBcszjs6VgXUdk/94hYSQjqnN3dyLS0dAdXTHJSCnsb5uCsSq67WUk5XsO5us+GW5OuTkqFM1Fi/EAKYuV44ERoUTJA4InoRQVFRk5KUhPTo2mBWE5ugRtIRlDTyqH1EJP2qGirMWV0wev/ymLg33oWrUf9RfbolK2yG7OhiZc7HhgOoSg6zAjkEJeU0c12BxvXD7G7LoB4Rb8m4uY4q1gbJLFtJzF45HRm6DrxKcGgIK7pm3LYdYfMGFlVWItmoZ0RTkkmktTIjzudUSicwnkSjLbELEOASHGXFlpkNvG4Py9aMjJeQKaVto+1IKsRRbJt3j9dq59CPfF9R5sf0Wj4DvZajVosF1IIZzDTw2JjiRbbi8iosEeSQYMKBpXbZ+HbVkGMlSqtQ0qwPFvXveq2hvioY3jyrO5o++ebxovK8N4adS8FDg68MpcVMWd6TA5hyc6SEGV9Z4eIAa8Qxx7HAGwPTbo7amMm2Sdv4PuzuXjtwaaDvKjzAbLDvbj4IKgaNLJaSIluvpWjryYfhlQPPvfu97ek/jlIbnmldetz96Fh6S3Aqu3f6qWXXpvl3dxf/uP2DzdGNvU/tPRG8dL29of9Yx8SQtaz02yOcNfLnpL6KsDLxYt+hjliw/7vPn1hfdOnq/RP2MN3bn//k+rkvKxctnrnpytaB8r9+X7Fl2evfxPubPl7dNmvjtV8mTe9+5IvDnz7w+Okjl2dwa39aO/a3+adPjWtac7byq/Vl1dGLkV9xbM3k2I6e8jNt56teOHrwwJKzXYdf/nBCK4699OL62hPihm0/vA2fvPzs1LNVHStI5Vio/3z4Lev+5nHNq/fsm/LGexfOH2romdc+/vy5mf4d7+/6+iPllXMXq/Y16vo7+18FZ7Yd47J7+TclrMKJ/REAAA==",
        "Content-Type: application/json",
        "X-EBAY-C-MARKETPLACE-ID: EBAY_US"
    )
    @GET("buy/browse/v1/item_summary/search")
    fun findEbayItem(@Query("q") item: String,
                     @Query("offset") offsetNum: Int,
                     @Query("filter") filterName: String)
    : retrofit2.Call<Item>

}