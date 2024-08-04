package yes1sir.yessir.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yes1sir.yessir.model.Product;
import yes1sir.yessir.model.SkinType;
import yes1sir.yessir.repository.ProductRepository;
import yes1sir.yessir.repository.SkinTypeRepository;

import jakarta.annotation.PostConstruct;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Service
public class DataInitializationService {

    private final ProductRepository productRepository;
    private final SkinTypeRepository skinTypeRepository;

    @Autowired
    public DataInitializationService(ProductRepository productRepository, SkinTypeRepository skinTypeRepository) {
        this.productRepository = productRepository;
        this.skinTypeRepository = skinTypeRepository;
    }

    @PostConstruct
    public void init() {
        // 피부 유형 저장
        SkinType DRPT = new SkinType();
        DRPT.setTypeName("DRPT");
        skinTypeRepository.save(DRPT);

        SkinType DRNT = new SkinType();
        DRNT.setTypeName("DRNT");
        skinTypeRepository.save(DRNT);

        SkinType DSPT = new SkinType();
        DSPT.setTypeName("DSPT");
        skinTypeRepository.save(DSPT);

        SkinType DSNT = new SkinType();
        DSNT.setTypeName("DSNT");
        skinTypeRepository.save(DSNT);

        SkinType DRPW = new SkinType();
        DRPW.setTypeName("DRPW");
        skinTypeRepository.save(DRPW);

        SkinType DRNW = new SkinType();
        DRNW.setTypeName("DRNW");
        skinTypeRepository.save(DRNW);

        SkinType DSPW = new SkinType();
        DSPW.setTypeName("DSPW");
        skinTypeRepository.save(DSPW);

        SkinType DSNW = new SkinType();
        DSNW.setTypeName("DSNW");
        skinTypeRepository.save(DSNW);

        SkinType ORPT = new SkinType();
        ORPT.setTypeName("ORPT");
        skinTypeRepository.save(ORPT);

        SkinType ORNT = new SkinType();
        ORNT.setTypeName("ORNT");
        skinTypeRepository.save(ORNT);

        SkinType OSPT = new SkinType();
        OSPT.setTypeName("OSPT");
        skinTypeRepository.save(OSPT);

        SkinType OSNT = new SkinType();
        OSNT.setTypeName("OSNT");
        skinTypeRepository.save(OSNT);

        SkinType ORPW = new SkinType();
        ORPW.setTypeName("ORPW");
        skinTypeRepository.save(ORPW);

        SkinType ORNW = new SkinType();
        ORNW.setTypeName("ORNW");
        skinTypeRepository.save(ORNW);

        SkinType OSPW = new SkinType();
        OSPW.setTypeName("OSPW");
        skinTypeRepository.save(OSPW);

        SkinType OSNW = new SkinType();
        OSNW.setTypeName("OSNW");
        skinTypeRepository.save(OSNW);



        // 제품 저장
        addProduct("원오브뎀", "[키링증정] 원오브뎀 드 뗑 쿠션 12g 2종 택 1", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020657314ko.jpg?l=ko", new BigDecimal(23600), "D,S", "여드름 억제, 반점 제거", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, OSPT, OSNT, OSPW, OSNW));
        addProduct("우르오스", "[옥택연Pick]우르오스 스킨워시 500ml 단품/기획(+메쉬파우치)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020580213ko.jpg?l=ko", new BigDecimal(15700), "O,W", "여드름 억제, 모공 청소, 반점 제거", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DRPW, DRNW, DSPW,DSNW));
        addProduct("아이디얼포맨", "[콜라겐]아이디얼 포 맨 퍼펙트 올인원 기획 2024 AD(150mL+30mL)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020787604ko.jpg?l=ko", new BigDecimal(22500), "D,R", "반점 제거, 모공 청소, 주름 제거, 탄력 증진", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORPT, ORNT, ORPW, ORNW));
        addProduct("라운드랩", "[민감진정] 라운드랩 포 맨 소나무 진정 토너/로션 2종 세트(+클렌저 40ml 증정)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0019/A00000019915608ko.jpg?l=ko", new BigDecimal(32000), "O,N", "질감 개선, 주름 제거, 반점 제거", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DRNT, DSNT, DRNW, DSNW));
        addProduct("라운드랩", "[고민진정] 라운드랩 포 맨 소나무 진정 시카 토너 200ml", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0019/A00000019915301ko.jpg?l=ko", new BigDecimal(18500), "D,S,P", "모공 청소, 주름 제거", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, OSPT, OSNT, OSPW, OSNW, ORPT, ORNT));
        addProduct("리우젤", "리우젤 그루밍 토닉 350ml 한정기획 (+서프토닉 100ml 증정)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0018/A00000018873705ko.jpg?l=ko", new BigDecimal(22400), "O,R,T", "질감 개선, 반점 제거, 탄력 증진", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DRPT, DRNT, DRPW, DRNW, DSPT, DSNT));
        addProduct("우르오스", "우르오스 스킨밀크 200ml", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0000/A00000000656508ko.jpg?l=ko", new BigDecimal(23700), "D,W", "탄력 증진, 주름 제거, 여드름 억제, 반점 제거", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORPW, ORNW, OSPW, OSNW));
        addProduct("오브제", "[덱스 PICK]오브제 퍼펙트 옴므 쿠션 15g (SPF50+PA++++)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0016/A00000016100608ko.jpg?l=ko", new BigDecimal(26900), "O,S", "주름 제거, 반점 제거", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, OSPW, OSNW, DSPT, DSNT, DSPW, DSNW));
        addProduct("랩시리즈", "랩시리즈 데일리 레스큐 하이드레이팅 에멀전 50ml", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0015/A00000015811007ko.jpg?l=ko", new BigDecimal(49600), "D,R,W", "모공 청소, 질감 개선, 탄력 증진", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORPT, ORNT, ORPW, ORNW, OSPT, OSNT));
        addProduct("라운드랩", "[저자극/수분진정] 라운드랩 포 맨 1025 독도 올인원 플루이드 200ml", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0018/A00000018323001ko.jpg?l=ko", new BigDecimal(17900), "O,N", "모공 청소, 반점 제거, 탄력 증진", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DRNT, DRNW, DSNT, DSNW));
        addProduct("그라펜", "[7월올영픽/누적판매150만] 그라펜 트리플립 핸섬립/컬러립/립센스/네이키드 립밤 (4종 택1)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020022809ko.jpg?l=ko", new BigDecimal(10500), "D,P", "여드름 억제, 탄력 증진", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORPT, ORPW, OSPT, OSPW));
        addProduct("다슈", "[종석 Pick]다슈 프로 에어리 폴리쉬 오일 100ml 기획세트(+10ml 증정)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0018/A00000018257705ko.jpg?l=ko", new BigDecimal(17900), "O,R", "여드름 억제, 반점 제거, 탄력 증진, 주름 제거", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DRPT, DRNT, DRPW, DSPW));
        addProduct("비레디", "[리뉴얼] 비레디 생기립밤 3g 01 화사생기 / 02 내추럴생기", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020627602ko.jpg?l=ko", new BigDecimal(10300), "D,W", "주름 제거, 질감 개선, 반점 제거, 탄력 증진", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORPT, ORPW, OSPT, OSPW));
        addProduct("라운드랩", "[유분케어/지성맞춤] 라운드랩 포 맨 1025 독도 올인원 젤 로션 200ml 더블 기획", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0019/A00000019773904ko.jpg?l=ko", new BigDecimal(33000), "O,S", "모공 청소, 반점 제거, 여드름 억제, 주름 제거", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, OSPW, OSNW, DSPT, DSNT, DSPW, DSNW));
        addProduct("파나소닉", "파나소닉 ER-GK20 퍼스트 바디트리머", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020696601ko.jpg?l=ko", new BigDecimal(63000), "D,R", "질감 개선, 여드름 억제", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORPT, ORNT, ORPW, ORNW));
        addProduct("오브제", "[덱스 PICK]오브제 무드체인지 립밤 3g 2종 택1", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0016/A00000016100708ko.jpg?l=ko", new BigDecimal(10700), "O, W, T", "여드름 억제, 탄력 증진", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DRPW, DRNW, DSPW, DSNW, DRPT, DSPT));

        addProduct("캘빈클라인", "CK 캘빈클라인 에브리원 EDP 50ml", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0018/A00000018330901ko.jpeg?l=ko", new BigDecimal(57300), "D, S, N", "탄력 증진, 주름 제거", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, OSPT, OSNT, OSPW, OSNW, ORNT, ORNW));

        addProduct("다슈", "[종석 Pick]다슈 포맨 밤부 포레스트 메가 하드 스프레이 180ml", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0016/A00000016143905ko.jpg?l=ko", new BigDecimal(9800), "O", "탄력 증진, 질감 개선", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW));

        addProduct("에이딕트", "에이딕트 오드퍼퓸 EDP 50ml 7종 택1 (기획/단품)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0015/A00000015968435ko.jpg?l=ko", new BigDecimal(49900), "D, T", "반점 제거, 탄력 증진", Set.of(DRPT, DRNT, DSPT, DSNT,DRPW, DRNW, DSPW, DSNW, ORPT, ORNT, OSPT, OSNT));

        addProduct("닥터지", "[7월한정/본품증정]닥터지 레드 블레미쉬 포 맨 플루이드/폼 2종기획(+톤로션 2ml*2 증정)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020745904ko.jpg?l=ko", new BigDecimal(22900), "O, W", "반점 제거, 질감 개선, 모공 청소", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DRPW, DRNW, DSPW, DSNW));

        addProduct("닥터지", "닥터지 레드 블레미쉬 포 맨 젠틀 포인트 클렌저 150mL", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0015/A00000015350403ko.jpg?l=ko", new BigDecimal(21900), "D, R, S", "탄력 증진, 질감 개선, 주름 제거, 여드름 억제", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORPT, ORNT, ORPW, ORNW, OSPT, OSPW, OSNT, OSNW));

        addProduct("갸스비", "[7월 올영픽] 갸스비 셋&킵 슈퍼하드 스프레이 263ml (레귤러)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0000/A00000000902016ko.jpg?l=ko", new BigDecimal(4900), "O, P", "여드름 억제, 반점 제거, 질감 개선, 탄력 증진", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DRPT, DSPT, DRPW, DSPW));

        addProduct("질레트", "질레트 랩스 딥클렌징바 면도날 [4입/8입/10입]", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020364401ko.jpg?l=ko", new BigDecimal(39900), "D, S, W", "질감 개선, 모공 청소, 여드름 억제", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, OSPT, OSNT, OSPW, OSNW, ORPW, ORNW));

        addProduct("라끌랑", "라끌랑 슈퍼쉴드 옴므쿠션 3종 택1", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0013/A00000013079801ko.jpg?l=ko", new BigDecimal(39000), "O, T", "질감 개선, 탄력 증진, 주름 제거, 여드름 억제", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DRPT, DRNT, DSPT, DSNT));

        addProduct("아이디얼포맨", "[올인원 톤커버로션]아이디얼 포 맨 베러톤 커버로션 기획 01/02 (+톤로션10ml)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020546005ko.jpg?l=ko", new BigDecimal(17600), "D", "여드름 억제, 주름 제거", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW));

        addProduct("비레디", "[7월 올영픽]비레디 트루 톤 로션 33ml+10ml 증정 기획(오리지널/에어리)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0018/A00000018923114ko.jpg?l=ko", new BigDecimal(29900), "O, S, W", "질감 개선, 모공 청소", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DSPT, DSNT, DSPW, DSNW, DRPW, DRNW));

        addProduct("비레디", "[7월 올영픽/1+1]비레디 시카페인 트러블리셋 세럼 40ml 리필 기획", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020749308ko.jpg?l=ko", new BigDecimal(35900), "D, R", "주름 제거, 반점 제거, 탄력 증진", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORPT, ORNT, ORPW, ORNW));

        addProduct("아이디얼포맨", "[초저분자 히알루론산]아이디얼 포 맨 프레시 올인원 기획 2024 AD(150mL+50mL)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020787904ko.jpg?l=ko", new BigDecimal(21500), "O, N", "여드름 억제, 모공 청소", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DRNT, DSNT, DRNW, DSNW));

        addProduct("우르오스", "우르오스 페이스워시 100g+100g 더블기획 [+8g 증정기획/더블기획]", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020509208ko.jpg?l=ko", new BigDecimal(20600), "D, W, P", "여드름 억제, 모공 청소, 질감 개선", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORPW, ORNW, OSPW, OSNW, OSPT, ORPT));

        addProduct("갸스비", "[7월 올영픽/ 1+1 한정기획] 갸스비 매트&하드 스프레이 200ml", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0011/A00000011470019ko.jpg?l=ko", new BigDecimal(8550), "O, S", "질감 개선, 여드름 억제, 모공 청소", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DSPT, DSNT, DSPW, DSNW));

        addProduct("우르오스", "우르오스 올인원 단품 2종 택 1", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0011/A00000011754116ko.jpg?l=ko", new BigDecimal(23700), "D, R, T", "반점 제거, 모공 청소", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORPT, ORNT, ORPW, ORNW, OSPT, OSNT));

        addProduct("커리쉴", "커리쉴 퍼펙션 컬크림 150ml 기획(+미니어처 30ml)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020420804ko.jpg?l=ko", new BigDecimal(22500), "O", "질감 개선, 탄력 증진, 주름 제거", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW));

        addProduct("오브제", "오브제 내추럴 커버 로션 50g", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020497503ko.jpg?l=ko", new BigDecimal(25900), "D, W", "여드름 억제, 모공 청소, 질감 개선", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORPW, ORNW, OSPW, OSNW));

        addProduct("질레트", "[리뉴얼] 질레트 면도날 16입 (스킨텍/옐로우/칠)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020587206ko.jpg?l=ko", new BigDecimal(91900), "O, S", "모공 청소, 질감 개선, 주름 제거", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DSPT, DSNT, DSPW, DSNW));

        addProduct("랩시리즈", "[1+1 한정기획] 랩시리즈 올인원 트리트먼트 50ml 1+1 기획세트", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0017/A00000017924907ko.jpg?l=ko", new BigDecimal(45000), "D, R, P", "탄력 증진, 주름 제거", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORPT, ORNT, ORPW, ORNW, OSPT, OSPW));

        addProduct("비레디", "비레디 트루 톤 로션 33ml 리필 기획 (본품+리필)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0019/A00000019286606ko.jpg?l=ko", new BigDecimal(39900), "O, T", "탄력 증진, 여드름 억제, 반점 제거, 모공 청소", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DRPT, DRNT, DSPT, DSNT));

        addProduct("갸스비", "갸스비 그로스&하드 워터 스프레이 250ml", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0016/A00000016829506ko.jpg?l=ko", new BigDecimal(9000), "D", "여드름 억제, 모공 청소", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW));

        addProduct("비레디", "비레디 블루 파운데이션(피카소 퍼프+퍼프케이스 증정)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0018/A00000018108205ko.jpg?l=ko", new BigDecimal(21900), "O, R, S", "여드름 억제, 탄력 증진", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DRPT, DRNT, DRPW, DRNW, DSPW, DSNW));

        addProduct("아이디얼포맨", "[시카]아이디얼 포 맨 시카 올인원 기획 2024 AD(150mL+50mL)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020787802ko.jpg?l=ko", new BigDecimal(21500), "D, W", "모공 청소, 탄력 증진", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORPW, ORNW, OSPW, OSNW));

        addProduct("비레디", "비레디 트루 톤 로션 33ml (오리지널/에어리)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0018/A00000018719512ko.jpg?l=ko", new BigDecimal(29900), "O", "모공 청소, 탄력 증진", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW));

        addProduct("그레이그라운드", "그레이그라운드 퍼퓸 향수 3종 택1", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0015/A00000015266601ko.jpg?l=ko", new BigDecimal(59000), "D, S", "질감 개선, 여드름 억제, 모공 청소, 탄력 증진", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, OSPT, OSNT, OSPW, OSNW));

        addProduct("다비도프", "[NEW] 다비도프 쿨워터 맨 EDT 125ml 기획(+향수공병+리필스틱)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0018/A00000018380703ko.jpg?l=ko", new BigDecimal(57200), "O, W, P", "주름 제거, 탄력 증진, 여드름 억제, 반점 제거", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, DRPW, DRNW, DSPW, DSNW, DSPT, DRPT));

        addProduct("비레디", "비레디 블루쿠션&립밤 기획세트 3종 택1 (블루쿠션+내추럴 생기립밤)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020445303ko.jpg?l=ko", new BigDecimal(25900), "D, R", "주름 제거, 모공 청소, 반점 제거", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORPT, ORNT, ORPW, ORNW));

        addProduct("오브제", "[덱스 PICK]오브제 씬 스틸 컨실러 5g", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0016/A00000016109308ko.jpg?l=ko", new BigDecimal(14900), "O, T, N", "여드름 억제, 질감 개선, 탄력 증진, 반점 제거", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DRPT, DRNT, DSPT, DSNT, DRNW, DSNW));

        addProduct("다슈", "다슈 데일리 볼륨업 컬크림 150ml (볼륨컬링 스타일링)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0011/A00000011123816ko.jpg?l=ko", new BigDecimal(10500), "D, S", "탄력 증진, 주름 제거", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, OSPT, OSNT, OSPW, OSNW));

        addProduct("아이디얼포맨", "[초저분자 히알루론산]아이디얼 포 맨 프레시 올인원 150mL 단품/기획(2024 AD)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020647402ko.jpg?l=ko", new BigDecimal(21500), "O, W", "모공 청소, 질감 개선, 여드름 억제, 반점 제거", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, DRPW, DRNW, DSPW, DSNW));

        addProduct("아이디얼포맨", "아이디얼 포 맨 다리털 트리머(1개입)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020562502ko.jpg?l=ko", new BigDecimal(4050), "D, R, S", "여드름 억제, 모공 청소, 반점 제거, 탄력 증진", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORPT, ORNT, ORPW, ORNW, OSPT, OSPW, OSNT, OSNW));

        addProduct("필립스", "필립스 그루밍 멀티 트리머(NT3650/16)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0014/A00000014659401ko.jpg?l=ko", new BigDecimal(19000), "O", "질감 개선, 주름 제거", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW));

        addProduct("다슈", "다슈 맨즈 매직커버 니플밴드 (52매)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0014/A00000014312701ko.jpg?l=ko", new BigDecimal(12000), "D, T, P", "반점 제거, 질감 개선", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORPT, ORNT, OSPT, OSNT, ORPW, OSPW));

        addProduct("비레디", "[NEW] 비레디 블루 수분 선크림 50ml", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0018/A00000018355208ko.jpg?l=ko", new BigDecimal(17500), "O, W", "주름 제거, 모공 청소, 여드름 억제", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DRPW, DRNW, DSPW, DSNW));

        addProduct("오브제", "[7월 올영픽 / 덱스 PICK] 오브제 내추럴 커버 파운데이션 기획세트(+클렌징폼 50ml)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0019/A00000019800106ko.jpg?l=ko", new BigDecimal(29800), "D, S", "반점 제거, 여드름 억제, 모공 청소, 질감 개선", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, OSPT, OSNT, OSPW, OSNW));

        addProduct("라운드랩", "[남자피부맞춤] 라운드랩 포맨 자작나무 토너/로션 2종 세트 (+쉐이빙폼 40ml 증정)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0018/A00000018767509ko.jpg?l=ko", new BigDecimal(31500), "O, N", "모공 청소, 질감 개선, 주름 제거, 반점 제거", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DRNT, DSNT, DRNW, DSNW));

        addProduct("닥터지", "닥터지 레드 블레미쉬 포 맨 올인원 오일컷 로션 150ml 기획(+30ml 추가증정)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0018/A00000018523509ko.jpg?l=ko", new BigDecimal(20300), "D, R", "반점 제거, 주름 제거", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORPT, ORNT, ORPW, ORNW));

        addProduct("포맨트", "[1위향수]포맨트 시그니처 퍼퓸 50ml (코튼허그) 단품/기획", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0016/A00000016174729ko.jpg?l=ko", new BigDecimal(39000), "O, W", "모공 청소, 반점 제거", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, DRPW, DRNW, DSPW, DSNW));

        addProduct("포맨트", "포맨트 시그니처 코튼 스프레이 코튼허그 200ml", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0016/A00000016103405ko.jpg?l=ko", new BigDecimal(21000), "D", "모공 청소, 반점 제거", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW));

        addProduct("피지오겔", "피지오겔 DMT포맨 증정 기획세트 2종 (플루이드 or 크림)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0017/A00000017922709ko.jpg?l=ko", new BigDecimal(32900), "O, S", "주름 제거, 탄력 증진, 반점 제거", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DSPT, DSNT, DSPW, DSNW));

        addProduct("포맨트", "[1위향수]포맨트 시그니처 퍼퓸 50ml 2종 택1 (코튼키스/코튼허그)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0016/A00000016360718ko.jpg?l=ko", new BigDecimal(37000), "D, R, W", "주름 제거, 모공 청소, 질감 개선, 탄력 증진", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORPT, ORNT, ORPW, ORNW, OSPT, OSNT));

        addProduct("피지오겔", "[한정기획] 피지오겔 시카밸런스 포맨 2종 기획 (토너 200ml + 플루이드 100ml)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020459002ko.jpg?l=ko", new BigDecimal(34900), "O", "모공 청소, 주름 제거, 질감 개선", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW));

        addProduct("아이디얼포맨", "[세미매트/밀착쿠션]아이디얼 포 맨 베러톤 커버 쿠션 단품/기획", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0018/A00000018189307ko.jpg?l=ko", new BigDecimal(18800), "D, N, T", "모공 청소, 질감 개선", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORNT, OSNT, ORNW, OSNW, ORPT, OSPT));

        addProduct("아이오페", "[단독기획] 아이오페 맨 올데이 퍼펙트 올인원 120ml 기획(+30ml 증정)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0018/A00000018469714ko.jpg?l=ko", new BigDecimal(28500), "O, S, W", "여드름 억제, 반점 제거, 탄력 증진", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DSPT, DSNT, DSPW, DSNW, DRPW, DRNW));

        addProduct("아이디얼포맨", "[올리브영 1등]아이디얼 포 맨 니플 밴드(스킨톤) 64매입 [32회분]", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0018/A00000018322804ko.jpg?l=ko", new BigDecimal(15000), "D", "모공 청소, 주름 제거, 질감 개선, 여드름 억제", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW));

        addProduct("AHC", "[올리브영 단독] AHC 온리포맨 스킨케어 2종 기프트 세트", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0017/A00000017348901ko.jpg?l=ko", new BigDecimal(22900), "O, R", "여드름 억제, 주름 제거, 탄력 증진", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DRPT, DRNT, DRPW, DRNW));

        addProduct("캘빈클라인", "CK 캘빈클라인 씨케이올 EDT 100ml", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0018/A00000018239204ko.jpg?l=ko", new BigDecimal(67700), "D, W", "탄력 증진, 반점 제거, 모공 청소, 주름 제거", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORPW, ORNW, OSPW, OSNW));

        addProduct("라끌랑", "라끌랑 내츄럴 커버 옴므쿠션 3종 택1", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0013/A00000013081401ko.jpg?l=ko", new BigDecimal(31500), "O, S, T", "여드름 억제, 모공 청소", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DSPT, DSNT, DSPW, DSNW, DRPT, DRNT));

        addProduct("메르세데스 벤츠", "메르세데스 벤츠 맨 EDT 30ml/50ml/100ml 3종 택1", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0014/A00000014137401ko.jpg?l=ko", new BigDecimal(32000), "D, R", "여드름 억제, 탄력 증진, 주름 제거, 모공 청소", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORPT, ORNT, ORPW, ORNW));

        addProduct("그레이그라운드", "그레이그라운드 생폴드방스 향수 50ml", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0018/A00000018471402ko.jpg?l=ko", new BigDecimal(59000), "O", "주름 제거, 반점 제거, 탄력 증진, 모공 청소", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW));

        addProduct("토리든", "[올영픽/티벳동생PICK] 토리든 다이브인 포맨 저분자 히알루론산 스킨/젤로션 2종 기획(+스킨30ml+젤로션20ml)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020711503ko.jpg?l=ko", new BigDecimal(27750), "D, W", "반점 제거, 질감 개선, 모공 청소", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORPW, ORNW, OSPW, OSNW));

        addProduct("존바바토스", "존바바토스 아티산 블루 EDT 125ml", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0001/A00000001326214ko.jpg?l=ko", new BigDecimal(50800), "O, S", "주름 제거, 모공 청소, 질감 개선, 반점 제거", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DSPT, DSNT, DSPW, DSNW));

        addProduct("다슈", "[종석 pick] 다슈 맨즈 비타붐 톤업크림 50ml", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0013/A00000013894902ko.jpg?l=ko", new BigDecimal(14800), "D, R", "모공 청소, 탄력 증진, 여드름 억제, 질감 개선", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORPT, ORNT, ORPW, ORNW));

        addProduct("다슈", "[7월 올영픽]다슈 데일리 볼륨업 컬크림 150ml 기획 (+그루밍토닉 30ml)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020729401ko.jpg?l=ko", new BigDecimal(10500), "O, T", "반점 제거, 여드름 억제", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DRPT, DRNT, DSPT, DSNT));

        addProduct("다슈", "다슈 프리미엄 퍼퓸 50ml 5종 택1 (아쿠아 다이브 외)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0015/A00000015402812ko.jpg?l=ko", new BigDecimal(44000), "D, P", "주름 제거, 여드름 억제, 반점 제거", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORPT, OSPT, ORPW, OSPW));

        addProduct("라운드랩", "[고민진정] 라운드랩 포 맨 소나무 진정 시카 크림 75ml", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0019/A00000019915501ko.jpg?l=ko", new BigDecimal(19900), "O, S, R", "질감 개선, 탄력 증진", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DSPT, DSNT, DSPW, DSNW, DRNT, DRNW));

        addProduct("플리프", "플리프 시카-알로에 카밍 올인원 로션 (200ml+50ml)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0014/A00000014584013ko.jpg?l=ko", new BigDecimal(18800), "D, W", "여드름 억제, 탄력 증진, 모공 청소, 질감 개선", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORPW, ORNW, OSPW, OSNW));

        addProduct("폴미첼", "폴미첼 티트리 스페셜 샴푸 1000ml (리뉴얼)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020640502ko.jpg?l=ko", new BigDecimal(36900), "O", "질감 개선, 탄력 증진", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW));

        addProduct("불독", "불독 센시티브 쉐이브젤 175ml", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020632007ko.jpg?l=ko", new BigDecimal(10900), "D, R", "반점 제거, 여드름 억제, 탄력 증진", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORPT, ORNT, ORPW, ORNW));

        addProduct("오브제", "[7월 올영픽 / 덱스 PICK] 오브제 내추럴 커버 로션 50g 단품/기획(+미니어처 10ml)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020497904ko.jpg?l=ko", new BigDecimal(25900), "O, W, T", "질감 개선, 탄력 증진, 모공 청소", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DRPW, DRNW, DSPW, DSNW, DRPT, DSPT));

        addProduct("니베아", "니베아 맨 센서티브 쉐이빙 폼 더블 기획 (200ml+200ml)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020014903ko.jpg?l=ko", new BigDecimal(9700), "D, S", "탄력 증진, 질감 개선, 반점 제거", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, OSPT, OSNT, OSPW, OSNW));

        addProduct("히든", "히든 퍼퓸 스프레이 바디로션 단품/기획 5종", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0018/A00000018212716ko.jpg?l=ko", new BigDecimal(29600), "O", "여드름 억제, 모공 청소, 탄력 증진", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW));

        addProduct("포맨트", "포맨트 올인원 퍼퓸샤워 500ml (4종 택1)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0016/A00000016716814ko.jpg?l=ko", new BigDecimal(21600), "D", "질감 개선, 주름 제거", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW));

        addProduct("아이디얼포맨", "[올리브영 1등]아이디얼 포 맨 니플 밴드(투명) 72매입 [36회분]", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0018/A00000018322604ko.jpg?l=ko", new BigDecimal(15000), "O, S", "여드름 억제, 탄력 증진", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DSPT, DSNT, DSPW, DSNW));

        addProduct("토리든", "[올영픽/티벳동생PICK] 토리든 다이브인 포맨 저분자 히알루론산 올인원 200g 단품/기획 (+클렌징폼 30ml)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020711107ko.jpg?l=ko", new BigDecimal(16800), "D, R, W", "탄력 증진, 질감 개선, 여드름 억제, 모공 청소", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORPT, ORNT, ORPW, ORNW, OSPT, OSNT));

        addProduct("포맨트", "포맨트 시그니처 퍼퓸 50ml (코튼키스)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0016/A00000016716510ko.jpg?l=ko", new BigDecimal(37000), "O", "주름 제거, 질감 개선", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW));

        addProduct("다슈", "다슈 데일리 비타플렉스 올인원 바디워시 기획세트 (본품500ml+50ml 증정)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0015/A00000015233212ko.jpg?l=ko", new BigDecimal(11900), "D, T", "탄력 증진, 반점 제거", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORPT, ORNT, OSPT, OSNT));

        addProduct("비레디", "[7월 올영픽]비레디 블루 수분 선크림 50ml 1+1 기획", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020629709ko.jpg?l=ko", new BigDecimal(23700), "O, R, S", "모공 청소, 반점 제거, 주름 제거", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DSPT, DSNT, DSPW, DSNW, DRNT, DRNW));

        addProduct("도루코", "도루코 PACE7II FRESH 면도기+면도날 7입", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0016/A00000016260704ko.jpg?l=ko", new BigDecimal(19900), "D, W", "여드름 억제, 탄력 증진", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORPW, ORNW, OSPW, OSNW));

        addProduct("라운드랩", "[화해1위] 라운드랩 포 맨 소나무 진정 시카 로션 200ml", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0019/A00000019915405ko.jpg?l=ko", new BigDecimal(18500), "O, N", "반점 제거, 탄력 증진, 주름 제거, 모공 청소", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DRNT, DSNT, DRNW, DSNW));

        addProduct("보닌", "보닌 더스타일 스탠다드 2종 기획", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0001/A00000001704504ko.jpg?l=ko", new BigDecimal(35000), "D, S", "모공 청소, 탄력 증진", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, OSPT, OSNT, OSPW, OSNW));

        addProduct("라운드랩", "[저자극] 라운드랩 포 맨 1025 독도 올인원 플루이드 200ml 더블 기획", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0018/A00000018322904ko.jpg?l=ko", new BigDecimal(33000), "O", "반점 제거, 여드름 억제", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW));

        addProduct("아이디얼포맨", "[쿨링캡슐]아이디얼 포 맨 선 올인원 기획 2024 AD(120mL+20mL)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020788004ko.jpg?l=ko", new BigDecimal(20500), "D, R", "질감 개선, 탄력 증진, 모공 청소, 주름 제거", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORPT, ORNT, ORPW, ORNW));

        addProduct("비레디", "비레디 블루쿠션 SPF 34 PA++/15g (본품/리필 택1)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0016/A00000016743117ko.jpg?l=ko", new BigDecimal(21900), "O, W", "반점 제거, 탄력 증진", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DRPW, DRNW, DSPW, DSNW));

        addProduct("아이오페", "[THE NEW]아이오페 맨 2종세트(에센스145ml+에멀젼 120ml+3종미니어처 증정", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0018/A00000018386812ko.jpg?l=ko", new BigDecimal(58500), "D, P", "반점 제거, 모공 청소", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORPT, OSPT, ORPW, OSPW));

        addProduct("비레디", "[NEW] 비레디 블루 쿠션(리필) 15g", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0016/A00000016743306ko.jpg?l=ko", new BigDecimal(13080), "O, S", "모공 청소, 탄력 증진, 질감 개선, 반점 제거", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DSPT, DSNT, DSPW, DSNW));

        addProduct("몽블랑", "[더 보이즈 영훈 포토카드 증정] 몽블랑 익스플로러 플래티넘 EDP 30ml", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0019/A00000019165105ko.jpg?l=ko", new BigDecimal(50200), "D, R", "여드름 억제, 주름 제거", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORPT, ORNT, ORPW, ORNW));

        addProduct("무슈제이", "무슈제이 수분 선 에센스 더블기획(50ml+50ml)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0017/A00000017690022ko.jpg?l=ko", new BigDecimal(22900), "O, W", "주름 제거, 반점 제거, 여드름 억제", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DRPW, DRNW, DSPW, DSNW));

        addProduct("스웨거", "[1+1] 스웨거 헤어 세터 슈퍼하드 스프레이 250ml 더블 기획", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0018/A00000018257303ko.jpg?l=ko", new BigDecimal(14250), "D", "주름 제거, 탄력 증진", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW));

        addProduct("커리쉴", "[NEW] 커리쉴 새틴 앤 에어리 스프레이 300ml", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020421405ko.jpg?l=ko", new BigDecimal(13500), "O, S", "여드름 억제, 모공 청소, 질감 개선", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DSPT, DSNT, DSPW, DSNW));

        addProduct("라네즈", "[선착순 T1 멀티파우치 증정] 라네즈옴므 블루에너지 2종 기획 (미니어처 2종 포함)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0014/A00000014318912ko.jpg?l=ko", new BigDecimal(40300), "D, R", "질감 개선, 모공 청소, 탄력 증진", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORPT, ORNT, ORPW, ORNW));

        addProduct("아이디얼포맨", "[세미매트/밀착쿠션]아이디얼 포 맨 베러톤 커버 쿠션 기획 2종(+톤로션 10mL)", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020240502ko.jpg?l=ko", new BigDecimal(18800), "O", "탄력 증진, 주름 제거, 반점 제거, 질감 개선", Set.of(OSPT, DRPT));

        addProduct("아이디얼포맨", "[올인원 톤커버로션]아이디얼 포 맨 베러톤 커버로션 40mL", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020240305ko.jpg?l=ko", new BigDecimal(17600), "D, W, P", "반점 제거, 모공 청소, 질감 개선", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW));

        addProduct("포르맨즈", "포르맨즈 쿨클린존 남성청결제 아이스에디션 150ml", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0014/A00000014399205ko.jpg?l=ko", new BigDecimal(17000), "O, T", "모공 청소, 여드름 억제", Set.of(ORPT, ORNT, OSPT, OSNT, ORPW, ORNW, OSPW, OSNW, DRPT, DRNT, DSPT, DSNT));

        addProduct("엠도씨", "멘진 올인원", "https://www.mdockorea.com/shopimages/mdoc/008003000004.jpg?1712131188", new BigDecimal(29600), "D, W", "주름 제거, 질감 개선, 모공 청소", Set.of(DRPT, DRNT, DSPT, DSNT, DRPW, DRNW, DSPW, DSNW, ORPW, ORNW, OSPW, OSNW));


    }

    private SkinType saveSkinType(String typeName) {
        SkinType skinType = new SkinType();
        skinType.setTypeName(typeName);
        return skinTypeRepository.save(skinType);
    }

    private void addProduct(String brand, String name, String imageUrl, BigDecimal price, String recommendedType, String benefits, Set<SkinType> applicableTypes) {
        // 중복 여부 확인
        if (productRepository.existsByBrandAndName(brand, name)) {
            return; // 이미 존재하면 추가하지 않음
        }

        // 새로운 제품 생성 및 저장
        Product product = new Product();
        product.setBrand(brand);
        product.setName(name);
        product.setImageUrl(imageUrl);
        product.setPrice(price);
        product.setRecommendedType(recommendedType);
        product.setBenefits(benefits);
        product.setApplicableSkinTypes(applicableTypes);
        productRepository.save(product);
    }
}
