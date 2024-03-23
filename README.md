<table>
  <tr>
    <td><img src="https://github.com/DenisKsantopulos/eBay_Products_Search/blob/master/my_res/icon_app.png" alt="cr_acc" width="150"></td>
    <td><p align="left">
   <h2>eBay Products Search</h2>
</p>
<p align="left">
  PET project: eBay Products Search
</p></td>
  </tr>
</table>

# eBay Products Search
An application that uses the eBay API to list items in real time, written in Kotlin and with Clean Architecture.
https://developer.ebay.com
## Description
This project utilizes eBay's Browse API to access real-time listings of items on ebay.com, using Kotlin programming language. Users have the ability to search for items and view details such as price with shipping, seller information and product condition. Additionally, users can select an item to be directed to its page on the browser or eBay mobile app (if installed). The project also offers filtering options like free shipping and price range(TODO). The user can register in the application and log in under his account in the future(used SQLite).
# RU
Приложение, использующее API eBay для вывода списка товаров в режиме реального времени, написанное на Kotlin с использованием Clean Architecture.
https://developer.ebay.com
## Описание
В этом проекте используется API-интерфейс браузера eBay для доступа к спискам товаров на ebay.com в режиме реального времени с использованием языка программирования Kotlin. Пользователи могут искать товары и просматривать такие детали, как "цена с доставкой", "информация о продавце" и "состояние товара". Кроме того, пользователи могут выбрать товар. При нажатии на него вы будете перенаправлены на его страницу в браузере или мобильном приложении eBay (если оно установлено). Вы также можете применять такие параметры фильтрации, как бесплатная доставка и диапазон цен (TODO). Пользователь может зарегестироваться в приложении и в будущем входить под своим аккаунтом(использовал SQLite).
# Demonstration
<table>
  <tr>
    <td><img src="https://github.com/DenisKsantopulos/eBay_Products_Search/blob/master/my_res/create_acc.jpg" alt="cr_acc" width="250"></td>
    <td><img src="https://github.com/DenisKsantopulos/eBay_Products_Search/blob/master/my_res/log_in.jpg" alt="log_in" width="250"></td>
    <td><img src="https://github.com/DenisKsantopulos/eBay_Products_Search/blob/master/my_res/home.jpg" alt="home" width="250"></td>
    <td><img src="https://github.com/DenisKsantopulos/eBay_Products_Search/blob/master/my_res/search.gif" alt="home" width="250"></td>
  </tr>
</table>

# Стэк технологий
- Clean Architecture
- MVVM(remains to be completed)
- Koin - DI фреймворк
- Retrofit - Взаимодействие с сетью
- SQLite - БД
# TODO
- Add Firebase or Room
- Add page with favorite products
- MVVM(remains to be completed)
- Coroutines
- Jetpack compose
