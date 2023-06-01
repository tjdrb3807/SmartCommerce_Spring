package SmartCommerce.eCommerce;

import SmartCommerce.eCommerce.category.Category;
import SmartCommerce.eCommerce.itemType.ItemType;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@RequiredArgsConstructor
public class InitDB {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit01();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager entityManager;

        public void dbInit01() {
            Category[] categoryList = {
                    createCategory("상의"),
                    createCategory("아우터"),
                    createCategory("바지"),
                    createCategory("원피스/스커트"),
                    createCategory("신발"),
                    createCategory("가방"),
                    createCategory("패션 소품"),
                    createCategory("언더웨어"),
                    createCategory("뷰티"),
                    createCategory("스포츠/레저"),
                    createCategory("라이프"),
                    createCategory("키즈"),
                    createCategory("브랜드")
            };

            ItemType[] topItemTypeList = {
                    createItemType("상의 신상", "https://image.msscdn.net/images/goods_img/20220810/2710588/2710588_1_220.jpg", 100),
                    createItemType("후드 티셔츠", "https://image.msscdn.net/images/goods_img/20220125/2326935/2326935_11_220.jpg", 100),
                    createItemType("맨투맨/스웨트셔츠", "https://image.msscdn.net/images/goods_img/20211011/2171559/2171559_3_220.jpg", 100),
                    createItemType("니트/스웨터", "https://image.msscdn.net/images/goods_img/20190902/1139175/1139175_5_220.jpg", 100),
                    createItemType("셔츠/블라우스", "https://image.msscdn.net/images/goods_img/20210514/1951470/1951470_1_220.jpg", 100),
                    createItemType("긴소매 티셔츠", "https://image.msscdn.net/images/goods_img/20220118/2313303/2313303_16765956852302_220.jpg", 100),
                    createItemType("반소매 티셔츠", "https://image.msscdn.net/images/goods_img/20220304/2398381/2398381_1_220.jpg", 100),
                    createItemType("민소매 티셔츠", "https://image.msscdn.net/images/goods_img/20210720/2034964/2034964_1_220.jpg", 100),
                    createItemType("파케/카라 티셔츠", "https://image.msscdn.net/images/goods_img/20210520/1959696/1959696_1_220.jpg", 100),
                    createItemType("기타 상의", "https://image.msscdn.net/images/goods_img/20230119/3034895/3034895_16752250753178_220.jpg", 100)
            };

            ItemType[] outerItemTypeList = {
                    createItemType("아우터 신상", "https://image.msscdn.net/images/goods_img/20200205/1291017/1291017_1_220.jpg", 200),
                    createItemType("후드 집업", "https://image.msscdn.net/images/goods_img/20210105/1737051/1737051_9_220.jpg", 200),
                    createItemType("블루종/MA-1", "https://image.msscdn.net/images/goods_img/20200205/1291017/1291017_1_220.jpg", 200),
                    createItemType("레더/라이더스 재킷", "https://image.msscdn.net/images/goods_img/20200901/1576682/1576682_6_220.jpg", 200),
                    createItemType("무스탕/퍼", "https://image.msscdn.net/images/goods_img/20161123/452483/452483_2_220.jpg", 200),
                    createItemType("트러커 재킷", "https://image.msscdn.net/images/goods_img/20210210/1790383/1790383_2_220.jpg", 200),
                    createItemType("슈트/블레이저 재킷", "https://image.msscdn.net/images/goods_img/20230220/3095294/3095294_16768925046211_125.jpg", 200),
                    createItemType("카디건", "https://image.msscdn.net/images/goods_img/20190902/1139192/1139192_6_220.jpg", 200),
                    createItemType("아노락 재킷", "https://image.msscdn.net/images/goods_img/20200729/1530516/1530516_16746267904084_220.jpg", 200),
                    createItemType("플리스/뽀글이", "https://image.msscdn.net/images/goods_img/20220830/2755493/2755493_6_220.jpg", 200),
                    createItemType("트레이닝 재킷", "https://image.msscdn.net/images/goods_img/20200729/1530516/1530516_16746267904084_220.jpg", 200),
                    createItemType("스타디움 재킷", "https://image.msscdn.net/images/goods_img/20220830/2752809/2752809_16735781320411_220.jpg", 200),
                    createItemType("환절기 코트", "https://image.msscdn.net/images/goods_img/20220908/2783109/2783109_1_220.jpg", 200),
                    createItemType("겨울 싱글 코트", "https://image.msscdn.net/images/goods_img/20210930/2155618/2155618_1_220.jpg", 200),
                    createItemType("겨울 더블 코트", "https://image.msscdn.net/images/goods_img/20220914/2789972/2789972_2_220.jpg", 200),
                    createItemType("겨울 기타 코드", "https://image.msscdn.net/images/goods_img/20220914/2789874/2789874_3_220.jpg", 200),
                    createItemType("롱패딩/롱헤비 아우터", "https://image.msscdn.net/images/goods_img/20200922/1616798/1616798_4_220.jpg", 200),
                    createItemType("숏패딩/숏헤비 아우터", "https://image.msscdn.net/images/goods_img/20220808/2704962/2704962_16723004587941_220.jpg", 200),
                    createItemType("패딩 베스트", "https://image.msscdn.net/images/goods_img/20220922/2813455/2813455_2_220.jpg", 200),
                    createItemType("베스트", "https://image.msscdn.net/images/goods_img/20220922/2813455/2813455_2_220.jpg", 200),
                    createItemType("사파리/헌팅 재킷", "https://image.msscdn.net/images/goods_img/20221011/2850024/2850024_7_220.jpg", 200),
                    createItemType("나일론/코치 재킷", "https://image.msscdn.net/images/goods_img/20220126/2329532/2329532_16762491689303_220.jpg", 200),
                    createItemType("기타 아우터", "https://image.msscdn.net/images/goods_img/20220811/2712233/2712233_1_220.jpg", 200)
            };

            ItemType[] pantsItemTypeList = {
                    createItemType("바지 신상", "https://image.msscdn.net/images/goods_img/20220519/2569078/2569078_1_220.jpg", 300),
                    createItemType("데님 팬츠", "https://image.msscdn.net/images/goods_img/20220805/2701527/2701527_1_220.jpg", 300),
                    createItemType("코튼 팬츠", "https://image.msscdn.net/images/goods_img/20150826/241111/241111_4_220.jpg", 300),
                    createItemType("슈트 팬츠/슬랙스", "https://image.msscdn.net/images/goods_img/20220805/2701476/2701476_1_220.jpg", 300),
                    createItemType("트레이닝/조거 팬츠", "https://image.msscdn.net/images/goods_img/20220809/2705702/2705702_16771202964485_220.jpg", 300),
                    createItemType("숏 팬츠", "https://image.msscdn.net/images/goods_img/20220401/2461247/2461247_26_220.jpg", 300),
                    createItemType("레깅스", "https://image.msscdn.net/images/goods_img/20210119/1753868/1753868_1_220.jpg", 300),
                    createItemType("점프 슈트/오버올", "https://image.msscdn.net/images/goods_img/20230131/3050727/3050727_16754302860134_220.jpg", 300),
                    createItemType("기타 바지", "https://image.msscdn.net/images/goods_img/20220519/2569079/2569079_1_220.jpg", 300)
            };

            ItemType[] onePieceTypeList = {
                    createItemType("원피스 신상", "https://image.msscdn.net/images/goods_img/20220609/2605850/2605850_1_220.jpg", 400),
                    createItemType("미니 원피스", "https://image.msscdn.net/images/goods_img/20220609/2605850/2605850_1_220.jpg", 400),
                    createItemType("미디 원피스", "https://image.msscdn.net/images/goods_img/20220908/2781047/2781047_1_220.jpg", 400),
                    createItemType("맥시 원피스", "https://image.msscdn.net/images/goods_img/20230126/3040651/3040651_16747223471255_220.jpg", 400)
            };

            ItemType[] skirtItemTypeList = {
                    createItemType("스커트 신산", "https://image.msscdn.net/images/goods_img/20230209/3070525/3070525_16759039160641_220.jpg", 401),
                    createItemType("미니스커트", "https://image.msscdn.net/images/goods_img/20221213/2981150/2981150_1_220.jpg", 401),
                    createItemType("미디스커트", "https://image.msscdn.net/images/goods_img/20221115/2942764/2942764_1_220.jpg", 401),
                    createItemType("롱스커트", "https://image.msscdn.net/images/goods_img/20220118/2313073/2313073_1_220.jpg", 401)
            };

            ItemType[] sneakersItemTypeList = {
                    createItemType("스니커즈 신상", "https://image.msscdn.net/images/goods_img/20220907/2778805/2778805_1_220.jpg", 500),
                    createItemType("캔버스/단화", "https://image.msscdn.net/images/goods_img/20220907/2778805/2778805_1_220.jpg", 500),
                    createItemType("스포츠 스니커즈", "https://image.msscdn.net/images/goods_img/20190827/1130307/1130307_1_220.jpg", 500),
                    createItemType("패션스니커즈화", "https://image.msscdn.net/images/goods_img/20210226/1817780/1817780_2_220.jpg", 500),
                    createItemType("기타 스니커즈", "https://image.msscdn.net/images/goods_img/20210107/1738685/1738685_2_220.jpg", 500)
            };

            ItemType[] shoesItemTypeList = {
                    createItemType("신발 신상", "https://image.msscdn.net/images/goods_img/20220629/2638808/2638808_2_220.jpg", 501),
                    createItemType("구두", "https://image.msscdn.net/images/goods_img/20201224/1730341/1730341_2_220.jpg", 501),
                    createItemType("로퍼", "https://image.msscdn.net/images/goods_img/20221019/2875380/2875380_1_220.jpg", 501),
                    createItemType("힐/펌프스", "https://image.msscdn.net/images/goods_img/20220627/2634979/2634979_1_220.png", 501),
                    createItemType("플랫 슈즈", "https://image.msscdn.net/images/goods_img/20220222/2378307/2378307_4_220.jpg", 501),
                    createItemType("블로퍼", "https://image.msscdn.net/images/goods_img/20201204/1714082/1714082_1_220.jpg", 501),
                    createItemType("샌들", "https://image.msscdn.net/images/goods_img/20220502/2533766/2533766_1_220.jpg", 501),
                    createItemType("슬리퍼", "https://image.msscdn.net/images/goods_img/20191022/1197831/1197831_2_220.jpg", 501),
                    createItemType("기타 신발", "https://image.msscdn.net/images/goods_img/20220715/2666623/2666623_1_220.jpg", 501),
                    createItemType("모카신/보트 슈즈", "https://image.msscdn.net/images/goods_img/20220318/2431144/2431144_1_220.jpg", 501),
                    createItemType("부츠", "https://image.msscdn.net/images/goods_img/20211020/2190788/2190788_2_220.jpg", 501),
                    createItemType("신발 용품", "https://image.msscdn.net/images/goods_img/20191226/1257055/1257055_1_220.jpg", 501)
            };

            for (Category category : categoryList) { entityManager.persist(category); }

            for (ItemType itemType : topItemTypeList) {
                entityManager.persist(itemType);
            }

            for (ItemType itemType : outerItemTypeList) {
                entityManager.persist(itemType);
            }

            for (ItemType itemType : pantsItemTypeList) {
                entityManager.persist(itemType);
            }

            for (ItemType itemType : onePieceTypeList) {
                entityManager.persist(itemType);
            }

            for (ItemType itemType : skirtItemTypeList) {
                entityManager.persist(itemType);
            }

            for (ItemType itemType : sneakersItemTypeList) {
                entityManager.persist(itemType);
            }

            for (ItemType itemType : shoesItemTypeList) {
                entityManager.persist(itemType);
            }
        }

        private Category createCategory(String title) {
            Category category = new Category();
            category.setTitle(title);

            return category;
        }

        private ItemType createItemType(String title, String thumbnailImageURL, Integer categoryID) {
            ItemType itemType = new ItemType();
            itemType.setItem_type_title(title);
            itemType.setItem_type_thumbnail_image_URL(thumbnailImageURL);
            itemType.setCategory_id(categoryID);

            return itemType;
        }
    }
}
