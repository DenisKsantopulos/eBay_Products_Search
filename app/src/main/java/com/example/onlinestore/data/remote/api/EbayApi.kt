package com.example.onlinestore.data.remote.api

import retrofit2.Call
import com.example.onlinestore.data.remote.models.Item
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface EbayApi {
    @Headers(
        "Accept: application/json",
        "Authorization:Bearer v^1.1#i^1#r^0#I^3#f^0#p^1#t^H4sIAAAAAAAAAOVYbWwURRi+65eppRQBAVGhLCKhze7N7t7nyh0evQInB9f2SoEC1tm9uevavd3tzhztoZimP0gIUX5gEYTYBn/Y4A80xmiMAQWlASUYjD9UCFH8SjTBgF8JhLh7V8q1EkB6iU28P5eZeeed53nmfWfeHdBTVl6zbcW2Pyvt9xQN9ICeIrudrQDlZaW1k4uLZpfaQJ6BfaDnkZ6S3uKfFmOYUnShCWFdUzGq7k4pKhaynX4qbaiCBrGMBRWmEBaIJMSCqyICxwBBNzSiSZpCVYdDfsrNiZLkAk4vYKHkEXmzV73us1nzU5KX83BOJ8v5eATiHmCOY5xGYRUTqBI/xQHOSQOeZr3NwCO4eIH3McDjbqWqW5CBZU01TRhABbJwhexcIw/rraFCjJFBTCdUIBxcFosGw6H61c2LHXm+AsM6xAgkaTy6VafFUXULVNLo1svgrLUQS0sSwphyBHIrjHYqBK+DuQv4Wal9nEcUPT4oukTRlXB7CyLlMs1IQXJrHFaPHKcTWVMBqUQmmdspaqohPo0kMtxabboIh6qtv8Y0VOSEjAw/Vb80uD7Y0EAFQkiV8UoM6aiqyCqKEbqhKUQjiKDLxbEuGrp9ECWAOLxQztuwzGNWqtPUuGyJhqtXa2QpMlGjsdo487QxjaJq1AgmiIUo3843oiHXam1qbhfTpF219hWlTCGqs83b78DIbEIMWUwTNOJh7EBWIj8FdV2OU2MHs7E4HD7d2E+1E6ILDkdXVxfTxTOakXRwALCOdasiMakdpSBl2lq5nrOXbz+BlrNUJGTOxLJAMrqJpduMVROAmqQCTh9wsr5h3UfDCozt/UdHHmfH6IwoVIZIPOd0Iy/rYVnghMhTiAwJDAepw8KBRJihU9DoQERXoIRoyYyzdAoZclzgXQmO9yYQHXf7ErTTl0jQoivuptkEQgAhUZR83v9TotxpqMeQZCBSkFgvWJx3dm4O6Ul33bomEkZpZ7qxy9nU1BnS3Y31cr07shJ3x1pra42Ug6v332k23JR8nSKbyjSb6xdCACvXCyfCCg0TFB8XvZik6ahBU2QpM7E2mDfiDdAgmRhSzDxKjotkUNfDhTmrC0bvXx4Td8e7cHfUf3Q/3ZQVtkJ2YrGy5mPTAdRlxrqBGElLOaxc16BZfljdbVnU4+Itm5XrhGJtksyxleO5kpPJ0mXwZokxENbShlltM1GrAmvWOpBq3mfE0BQFGS3suPM5lUoTKCpooiV2AQJchhPssjXLNeBxesfLS8pepW0T7UgqxFFcsvwuy2rH6I/8gC37Y3vtR0Gv/XCR3Q4WgwXsfDCvrHhNSfGk2VgmiJFhgsFyUjW/XQ3EdKCMDmWjaJrt0oG+FXWz66O7a55pzny2b8g2Ke+NYWATmDXyylBezFbkPTmAh26MlLJVMys5J+BZL/C4eN7XCubfGC1hZ5RM/7TvHcVfda/+2JxITd99ByvPDW3sBJUjRnZ7qa2k125r3/sqqGq58LywvfzNqd96t5692tZ9uOitt5NHPvjOfezYwbV7hnba9i7cP7lvofvCwpcGvuw4RmsXj3+1/3LvkjPLXtumqPzcipmX+bWH3j2h/T54/IsDgZ5DZy4u2bhWUHcuGozsm2KLGps++iTjmLSl8YHN37989vWnjvZPuSY8uf40u0AL/Db48f1zolf2vT+4p60qcWLXCyelzhf7N7xyZXlkUT8zt0H7tXzGySlHFtWy59f83LpjY2PltPgvP8xaOn3Nqa5rGyr6T61MTm/aPy/iD07d4oVH+91PqLvOP/7XG6ffe+7rqw9qnrbdZT8mv9lBMc9OvXjp84f1M/BDlSurKd861HTujyvhR3N7+TecNbuq/REAAA==",
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