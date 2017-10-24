#language: ru
Функционал: findTV

  Сценарий: Поиск телевизора в Яндекс-маркет

    Когда перешли "https://www.yandex.ru"
    И нажали "market" на странице "Yandex"
    И выбрали в Яндекс-маркет категорию "Электроника" - "Телевизоры"
    И заполнили на странице "YandexMarket" поле "marketFilterFieldLowPrice" значением "20000"
    И дождались окончания загрузки на странице Яндекс-Маркет
    И нажали "marketFilterCheckBoxSumsung" на странице "YandexMarket"
    И дождались окончания загрузки на странице Яндекс-Маркет
    И нажали "marketFilterCheckBoxLG" на странице "YandexMarket"
    И дождались окончания загрузки на странице Яндекс-Маркет
    И нажали "marketFilterUse" на странице "YandexMarket"
    И дождались окончания загрузки на странице Яндекс-Маркет
    Тогда проверили, что на странице отображается "12" предложений товара
    И сохранили первое предложение как "FirstOfferTV20102017"
    И заполнили на странице "YandexMarket" поле "searchField" значением "FirstOfferTV20102017"
    И нажали "searchButton" на странице "YandexMarket"
    Тогда открылась страница товара "FirstOfferTV20102017"



