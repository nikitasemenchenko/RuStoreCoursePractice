package com.example.rustorecoursepractice.data

import com.example.rustorecoursepractice.domain.Category
import javax.inject.Inject

class AppsApi  @Inject constructor(){
    suspend fun getApps(): List<AppDetailsDto> = listOf(
        AppDetailsDto(
            id = 1,
            name = "Яндекс Браузер с Алисой AI",
            developer = "ООО \"ЯНДЕКС\"",
            category = Category.INSTRUMENTS,
            smallDescription = "Быстрый и безопасный браузер",
            ageRating = 12,
            size = 250f,
            screenshotUrlList = listOf(
                "https://static.rustore.ru/imgproxy/h8fNpNAuSx8PW0GpBTCJUrD6RWHfOvQe4GzwcwxlHnA/preset:web_scr_prt_384/plain/https://static.rustore.ru/2025/10/25/6a/apk/579007/content/SCREENSHOT/b14e7901-1fcb-4045-94af-3464c359f224.jpg@webp",
                "https://static.rustore.ru/imgproxy/MF7hImFqzHKWdcoc5K4dwFYQnqAu82cTyqYhkTr0KVc/preset:web_scr_prt_384/plain/https://static.rustore.ru/2025/10/25/bc/apk/579007/content/SCREENSHOT/eb4422a7-36cf-4d11-a25a-456026f39cc7.jpg@webp",
                "https://static.rustore.ru/imgproxy/prN3LD4roozFjB_Qmv7tsoo_ZS0Fml2wy8cowkP2a_A/preset:web_scr_prt_384/plain/https://static.rustore.ru/2025/10/25/81/apk/579007/content/SCREENSHOT/1d9d8a7f-9d6d-4b53-9107-c379bbd1ce48.jpg@webp",
                "https://static.rustore.ru/imgproxy/gZ90DFm3oR1QkEfjxmlRfjTfN7mVp4C20EoCMR-93GM/preset:web_scr_prt_384/plain/https://static.rustore.ru/2025/10/25/b3/apk/579007/content/SCREENSHOT/816a1cc0-31aa-431f-a560-51aad66f7342.jpg@webp",
                "https://static.rustore.ru/imgproxy/Vuaqho-Sp9glFmZK1-fRIFpbBfn-dnAoW4mgB3aWkZM/preset:web_scr_prt_384/plain/https://static.rustore.ru/2025/10/25/5d/apk/579007/content/SCREENSHOT/73f275e3-9c51-42a0-91de-d42cf2254a06.jpg@webp"
            ),
            iconUrl = "https://static.rustore.ru/imgproxy/bZNt9jiZUOVXXOG0JdJQleTYIB2cFeE3MaWk7o897jE/preset:web_app_icon_160/plain/https://static.rustore.ru/2025/10/25/1e/apk/579007/content/ICON/939321c0-03f7-484d-9043-c0fb12736ef1.png@webp",
            description = "Яндекс Браузер — быстрый и безопасный браузер с Алисой AI и выгодными покупками."
        ),
        AppDetailsDto(
            id = 2,
            name = "Mail: Почта, Облако, Календарь",
            developer = "VK",
            category = Category.INSTRUMENTS,
            ageRating = 12,
            smallDescription = "Почтовый клиент для любых ящиков",
            size = 250f,
            screenshotUrlList = listOf(
                "https://static.rustore.ru/imgproxy/hqZAv5FhtrTRhiLi0Gq-608yCX2cuYGEeYWWpVAqg2A/preset:web_scr_prt_384/plain/https://static.rustore.ru/2025/12/18/89/apk/332223/content/SCREENSHOT/b52db684-6d22-4cf6-9922-ba5a1662418b.jpg@webp",
                "https://static.rustore.ru/imgproxy/hmUAFiKcxIQCXgBY5NlVnDlqySZPFOyGhFo0Zc2KQVo/preset:web_scr_prt_384/plain/https://static.rustore.ru/2025/12/18/01/apk/332223/content/SCREENSHOT/5d718229-2ded-47a1-a5cd-6045b92916c8.jpg@webp",
                "https://static.rustore.ru/imgproxy/l5xN1THVmOcNjb-y02gWSF97TgarzoVp7qlDBg2joPY/preset:web_scr_prt_384/plain/https://static.rustore.ru/2025/12/18/07/apk/332223/content/SCREENSHOT/8bac3224-1499-40c3-b645-121318e9b791.jpg@webp"
            ),
            iconUrl = "https://static.rustore.ru/imgproxy/G4zJRwh_JpnM5CLGpQU8bKCUWaCYJCXNWuK_vcqFmOY/preset:web_app_icon_160/plain/https://static.rustore.ru/2025/12/18/49/apk/332223/content/ICON/79bd5fd2-13fb-4218-874f-7d3d651d344f.png@webp",
            description = "Почта Mail — ваш быстрый и удобный почтовый клиент."
        ),
        AppDetailsDto(
            id = 3,
            name = "Яндекс Навигатор",
            developer = "ООО \"ЯНДЕКС\"",
            category = Category.TRANSPORT,
            ageRating = 12,
            smallDescription = "Парковки и заправки - по пути",
            size = 250f,
            screenshotUrlList = listOf(
                "https://static.rustore.ru/imgproxy/LLUSjsX4ya4Hl-LpFgxC1D4KKpPtYgb32U82ODabZOc/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/3/5/ce/apk/595135/content/SCREENSHOT/d74ff81a-6bbb-41ff-b26a-7c6d468267c2.jpg@webp",
                "https://static.rustore.ru/imgproxy/VDCg9h12ZsXMxpo3ZMTNNxex0SywQaETR8hXoX5fQog/preset:web_scr_prt_384/plain/https://static.rustore.ru/apk/595135/content/SCREENSHOT/916f577b-318c-4ab4-8795-5b8a576c2268.png@webp",
                "https://static.rustore.ru/imgproxy/5aWV-gDV_nkZrTBImLK-siQOw8mBSBEq0SKjsXTzjdA/preset:web_scr_prt_384/plain/https://static.rustore.ru/apk/595135/content/SCREENSHOT/1600ea6e-628d-404c-9c4f-a963afcc4e30.png@webp"
            ),
            iconUrl = "https://static.rustore.ru/imgproxy/FvKuW-aUKk34jUz1ZEPXebdfDR0ikU93-JJYC5_Oh4Y/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/595135/content/ICON/32cb5e63-9c59-4280-9a6a-c808113be88f.png@webp",
            description = "Выбирайте оптимальные маршруты. Навигатор прокладывает маршруты с учётом пробок, аварий и ремонтных работ. Он предлагает до трёх вариантов проезда и для каждого подсчитывает время в пути. Если маршрут проходит по платному участку, приложение предупредит и об этом."
        ),
        AppDetailsDto(
            id = 4,
            name = "Мой МТС",
            developer = "ПАО МТС",
            category = Category.INSTRUMENTS,
            ageRating = 16,
            smallDescription = "Мой МТС - центр экосистемы МТС",
            size = 250f,
            screenshotUrlList = listOf(
                "https://static.rustore.ru/imgproxy/L9kcZUYoEo9FLeIq7feh-svc1OjQfysBT6XGfSVjots/preset:web_scr_prt_384/plain/https://static.rustore.ru/2025/12/15/ce/apk/336831/content/SCREENSHOT/e3558c77-1ca4-42e2-ad1b-e086fbf1e23a.jpg@webp",
                "https://static.rustore.ru/imgproxy/aQzVVGedKPqy5VKrUlvTWdTwlYgGx8Dk_cC8Q8MJClI/preset:web_scr_prt_384/plain/https://static.rustore.ru/2025/12/15/bb/apk/336831/content/SCREENSHOT/dea85320-baab-4b65-9aab-cda9b7e09505.jpg@webp"
            ),
            iconUrl = "https://static.rustore.ru/imgproxy/uAJeOzFbun_tDiquzvvs_kieJ8ihjODiwCb7LGISdos/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/336831/content/ICON/ea6c9e63-bd7f-486f-ac3f-3e9069ecf018.png@webp",
            description = "Мой МТС — приложение, в котором удобно проверять баланс и расходы, настраивать тариф, подключать услуги для мобильных устройств, дома и не только, а также управлять сервисами экосистемы МТС."
        )
    )
}