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
        "Authorization:Bearer v^1.1#i^1#I^3#p^1#f^0#r^0#t^H4sIAAAAAAAAAOVYe2wURRjvtddChQIKRSiPHFuU5+7N7u29Fu7g6BU5gb6uNFhC2r292WPp3e6yM9f2JMrZCAkJQTQBJEho8BUTQCPGv1QISCAxRh6JQIx/EEk0mmg1UV4BnL07yrUSQHqJTbxscpmZb775/X7zffMC6bLyuVuWbblaYRlR3JsG6WKLhR0FystK540pKa4qLQJ5Bpbe9My0tafkp4VITMR1oQkiXVMRtHUn4ioSMpU+KmmogiYiBQmqmIBIwJIQDqxcIXAMEHRDw5qkxSlbKOijXB4pIrq8HuDgOVFyQlKr3vXZrPkoLgI87mgEuBxuSOxY0o5QEoZUhEUVk3bA8TRwkK+Z9QpOtwA8jMfpbKVsLdBAiqYSEwZQ/gxcIdPXyMP6YKgiQtDAxAnlDwWWhusDoWBtXfNCe54vf06HMBZxEg0s1WhRaGsR40n44GFQxloIJyUJIkTZ/dkRBjoVAnfBPAb8jNS82+ONyg4PBzwOnhcLI+VSzUiI+ME4zBolSssZUwGqWMGphylK1IishxLOleqIi1DQZv41JsW4IivQ8FG1SwIvBBoaKH8QqgpajkS6Xo0rKgxjuqEpSEMRik4nxzppEjkilEEkN1DWW07mQSPVaGpUMUVDtjoNL4EENRysDZ+nDTGqV+uNgIxNRHl2HHtXQ55vNSc1O4tJvE415xUmiBC2TPHhM9DfG2NDiSQx7PcwuCEjkY8SdV2JUoMbM7GYC59u5KPWYawLdntXVxfT5WA0I2bnAGDtq1euCEvrYEKkiK2Z61l75eEdaCVDRSJpTOwFnNIJlm4SqwSAGqP8vBfwrDen+0BY/sG1/6jI42wfmBGFyhCZi3IRt8vh5WWX0wkihcgQfy5I7SYOGBFTdEI0OiDW46IEaYnEWTIBDSUqOJwy5/DIkI66vDLNe2WZjjijLpqVIQQQRiKS1/N/SpRHDfUwlAyICxLrBYvzDRs6g3rMVbO6CYdgkk82dvFNTRuCuquxVql1rViOusOt8+YZCTtX63vUbLgv+Zq4QpRpJuMXQgAz1wsnwjINYRgdEr2wpOmwQYsrUmp4TbDDiDaIBk6FYZzkUWxIJAO6HirMWl0wev9ymXg83oXbo/6j/em+rJAZssOLldkfEQeirjDmDsRIWsJu5romkuOHWd2WQT0k3go5uQ4r1oRklq0SzR45mQxdBnVKjAGRljTIaZupN09gzVoHVMl+hg0tHodGCzvkfE4kkliMxOFwS+wCBLgiDrPNlnUDL+91ejjPkHhJma20bbgtSYVYiq3PPeax2j7wku8vyvzYHstx0GP5othiAQvBM2w1mFFWsspaMroKKRgyiigzSImp5O5qQKYDpnRRMYrHF/1xYOeymqra+l1zNzanzuw9VTQ6742hdy2Y1P/KUF7Cjsp7cgBT77WUsmOfruB44AAO1ut0A08rqL7XamUnWifc8r3SOOdAy6Fz24+Me3LO6X2bKndcABX9RhZLaZG1x1LU/k1nR2T8wSvCot7v3XfeXrszfWlsdeXti1eP9G3bcuhNy47T0hHm5oUqbkb72onliTlPuXe/Nqb11c1XTn781pRLevyXfTM/37M55lvFHqN/3//nYesxdO6D6pH7jp9cXF6+YP8ngF9zs3d2d2jPrL1n1R0XRwZmXPd9Nmn98TU/vnHp/cnp569VvDhZwbbplSfu9CV+3lV5g9w6prz07NfvvXN04qbpL6Nf7bPOWw8vPv9py+mjnaeoBVsnLHVPfmL7D3y6+3blX8HvLk+/1rfxRuyjd3/T+JqzB9n26yMag3NjbSeMtmPzN13edobbPW7ah+03hRutPjB7al9dw/yv6G9vTVukvH6q8ssyIzuXfwNtOWvP/REAAA==",
        "Content-Type: application/json",
        "X-EBAY-C-MARKETPLACE-ID: EBAY_US"
    )
    @GET("buy/browse/v1/item_summary/search")
    fun findEbayItem(@Query("q") item: String,
                     @Query("offset") offsetNum: Int,
                     @Query("filter") filterName: String)
    : retrofit2.Call<Item>

}