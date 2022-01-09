package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        // enum타입은 == 로 써야함
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }else {
            return 0;
        }
    }
}
