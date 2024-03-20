package com.example.onlinestore.data.remote.api

import retrofit2.Call
import com.example.onlinestore.domain.models.Item
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface EbayApi {
    @Headers(
        "Accept: application/json",
        "Authorization:Bearer v^1.1#i^1#p^1#I^3#r^0#f^0#t^H4sIAAAAAAAAAOVYbYwTRRi+3gdCoBqjIJxoyoJKDnY7u93uteu1Uto7ae6jpa1wXCJkujs9ltvu7u1MuSskcl4QQ0LEHyImGnPxFPUgYARJFJSEhBAlKFGJBD9ATAiJ/OFDMd4P3e0dR+8kgFwTL7F/mpl5553neeZ9550d0DNpSs2mJZuuOR33lPf1gJ5yh4OdCqZMqlpwb0V5dVUZKDJw9PXM66nsrbhQh2FWNcQEwoauYeTqzqoaFgudASpnaqIOsYJFDWYRFokkJkPNTSLHANEwdaJLukq5opEAJUAf8AmSBH21rMcPvFavdt1nSg9QMg8E3gt4FgKfR/ZZwxjnUFTDBGokQHGA42ngoTmQYv0iK4gcxwheTxvlWoZMrOiaZcIAKlhAKxbmmkVQb40UYoxMYjmhgtFQQzIWikbqW1J17iJfwWEZkgSSHB7dCusyci2Dag7dehlcsBaTOUlCGFPu4NAKo52Koetg7gJ+QemMJAsy4CS5FiLWx3tKImWDbmYhuTUOu0eR6UzBVEQaUUj+dopaaqTXIIkMt1osF9GIy/5bmoOqklGQGaDqF4dWhOJxKhhBmoIbMaRjmqpoKEnoeCJCI4ig18uxXhoKfogyID280JC3YZnHrBTWNVmxRcOuFp0sRhZqNFYbUKSNZRTTYmYoQ2xERXYce11DXmizN3VoF3NktWbvK8paQrgKzdvvwMhsQkwlnSNoxMPYgYJEAQoahiJTYwcLsTgcPt04QK0mxBDd7q6uLqbLw+hmu5sDgHW3NjclpdUoCynb1s71gr1y+wm0UqAiIWsmVkSSNyws3VasWgC0dirI+61E9g/rPhpWcGzvPzqKOLtHZ0SpMoT18xJCXonjJcEv8HwpMiQ4HKRuGwdKwzydhWYHIoYKJURLVpzlsshUZNHjzXAeXwbRsuDP0Lw/k6HTXlmg2QxCAKF0WvL7/k+JcqehnkSSiUhpYr1Ucd7ZuTZitAvh1gSJohyfW9rFJxKdEUNYWq/UC02NuDvZtmCBmXVz9YE7zYabkg+riqVMylq/JALYuV4yEZbomCB5XPSSkm6guK4qUn5ibbDHlOPQJPkkUq08ah8XyZBhREt0VpeK3r88Ju6Odwlr1H9Tn27KCtshO7FY2fOx5QAaCmNXIEbSs27dznVoXT/s7lUF1OPirVg31wnF2iI5xFaRh66cjG7TZfBaiTER1nOmddtmYvYNLKV3IM2qZ8TUVRWZy9hx53M2myMwraKJltglCHAFTrBiy9aywC9wrI8bFy+pUEpXTbQjqSRHcWXD3V2r3aO/8YNlhR/b6zgMeh2flTscoA48xs4FcyZVPFNZMa0aKwQxCswwWGnXrG9XEzEdKG9AxSx/oOzyW9uWhKvrY6/WrE/lT7x+tGxa0RND37Ng5sgjw5QKdmrRiwOYfWOkir3vISfHAw8HWD8rcFwbmHtjtJKdUflg/vLXx3e0POX3fTRzYM3571ZeLT+9DzhHjByOqrLKXkfZm917WmOd+UuP72une9QzWw8e2c/Gd1bPRxu6n2jc2fnho6n5ywcPu7gDJ1P3fzy79tgHrV/+uLKhpu3Fvi3h7WeFq+V7B3fQZ069ljk3i3r5uf4TR9av3PPFkYXbv7o43Rl//vyG1vBi5sA77/+x6UrLtUb4SHPn53xZ/6Ljf8UH+I2+yJYntza968537J79yvlddZ8c++X79uXs25d6d510dB5vdq66cO7ioXUpafufAwMrTi1y1H2bELSNPzX39042Xphx8OHJn1INav/vlYcWvoemzp2+eeDX3WevJcPK4M9nneucR2fN2vvS6dj+p7f5Nzu3zAmmovsHV3zzw28H39hWE5pHGVcSNSdrh/byb0mvMg38EQAA",
        "Content-Type: application/json",
        "X-EBAY-C-MARKETPLACE-ID: EBAY_US"
    )
    @GET("buy/browse/v1/item_summary/search")
    fun findEbayItem(
        @Query("q") item: String,
        @Query("offset") offsetNum: Int,
        @Query("filter") filterName: String
    )
            : Call<Item>
}