package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setUsername("member1");
            member.setHomeAddress(new Address("homeCity", "street", "10000"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자"); // HashSet에 들어감

            member.getAddressHistory().add(new AddressEntity("old1", "street", "10000"));
            member.getAddressHistory().add(new AddressEntity("old2", "street", "10000"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("============= START =============");
            Member findMember = em.find(Member.class, member.getId());

            //homeCity -> newCity
//            findMember.getHomeAddress().setCity("newCity"); // 값 타입을 setter로 변경하면 안된다!
//            Address old = findMember.getHomeAddress();
//            findMember.setHomeAddress(new Address("newCity", old.getStreet(), old.getZipcode())); // 이렇게 완전히 새로운 인스턴스로 갈아 끼워야 함
//
//            // 치킨 -> 한식
//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("한식");
//
//            findMember.getAddressHistory().remove(new AddressEntity("old1", "street", "10000")); // 여기서 equals, hashCode가 구현이 안되있으면 제대로 동작하지 않는다.
//            findMember.getAddressHistory().add(new AddressEntity("newCity1", "street", "10000"));

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally { em.close();
        }
        emf.close();
    }
}
