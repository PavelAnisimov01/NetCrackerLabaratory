package repository;

import laba1.common.Common;
import laba1.common.Man;
import laba1.contracts.Internet;
import laba1.contracts.Mobile;
import laba1.contracts.Tele;
import laba1.repository.RepoMethods;
import laba2.Search.SearchMethods;
import laba2.Sort.BoubleSorter;
import laba2.Sort.InsertionSorter;
import laba2.Sort.ShellSorter;
import laba3.impl.CsvAdd;
import laba3.impl.CsvAddImpl;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.function.Predicate;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Класс репозиторий тест, который тестирует методы.
 * @autor Анисимов Павел
 */

class RepoTest {
    Man man1=new Man(1L,"Anisimov Paul Sergeevich","01:01:2000","man","1",23);
    Man man2=new Man(2L,"Popova Marina Ivanovna","01:01:2005","woman","2",53);
    Man man3=new Man(3L,"Sidorov Ivan Sergeevich","01:01:1995","man","3",28);
    Common common1=new Mobile(1L,"10:10:2000","10:10:2010", 10L,man1,500,500,20);
    Common common2=new Internet(2L,"10:10:2001","10:10:2011", 30L,man2,500);
    Common common3=new Tele(3L,"10:10:2002","10:10:2009", 150L,man3,"CTC,TNT");

    @Test
    public void getAges(){
    Man man=new Man("a","01:01:2000","m","1111 000000");
    int actual=23;
    int expected = man.getAge();
    assertEquals(expected,actual);
    }

@Test
public void addContract(){
    RepoMethods repoMethods=new RepoMethods();
    repoMethods.setList(repoMethods.addCommon(common1));
    assertEquals(1,repoMethods.getList().length);
    repoMethods.setList(repoMethods.addCommon(common2));
    assertEquals(2,repoMethods.getList().length);
    repoMethods.setList(repoMethods.addCommon(common3));
    assertEquals(3,repoMethods.getList().length);

}
    @Test
    public void viewContract() {
        RepoMethods repoMethods=new RepoMethods();
        repoMethods.setList(repoMethods.addCommon(common1));
        repoMethods.setList(repoMethods.addCommon(common2));
        repoMethods.setList(repoMethods.addCommon(common3));
        repoMethods.viewContract(2L);
        repoMethods.viewContract(3L);
        repoMethods.viewContract(1L);
    }
    @Test
    public void deleteCommon(){
        RepoMethods repoMethods=new RepoMethods();
        repoMethods.setList(repoMethods.addCommon(common1));
        repoMethods.setList(repoMethods.addCommon(common2));
        repoMethods.setList(repoMethods.addCommon(common3));
        repoMethods.setList(repoMethods.deleteCommon(2L));
        assertEquals(2,repoMethods.getList().length);
        Common[] commons=repoMethods.getList();
        assertEquals(1L,commons[0].getID());
        assertEquals(3L,commons[1].getID());

    }

    @Test
    public void find(){
        Common[]commons=new Common[]{common1,common2,common3};
        SearchMethods searchMethods=new SearchMethods();
        searchMethods.setList(commons);
        Predicate<Common> condition=p -> p.getMan().getID().equals(1L);
        SearchMethods newSearchMethods= searchMethods.find(condition);
        String expected="Anisimov Paul Sergeevich";
        Common[] commons1= newSearchMethods.getList();
        String actual=commons1[0].getMan().getFio();
        assertEquals(expected, actual);

    }
    @Test
    public void sort(){
        Common[]commons=new Common[]{common1,common2,common3};

        InsertionSorter insertionSorter=new InsertionSorter();
        insertionSorter.setList(commons);
        Comparator<Common> comp=(o1, o2) -> o2.getMan().getAge().compareTo(o1.getMan().getAge());
        insertionSorter.sort(comp);
        for (int i = 0; i < insertionSorter.getList().length; i++) {
            System.out.println(Array.get(insertionSorter.getList(), i));
        }
        System.out.println();

        BoubleSorter boubleSorter=new BoubleSorter();
        boubleSorter.setList(commons);
        comp=(o1, o2) -> o2.getMan().getID().compareTo(o1.getMan().getID());
        boubleSorter.sort(comp);
        for (int i = 0; i < insertionSorter.getList().length; i++) {
            System.out.println(Array.get(insertionSorter.getList(), i));
        }
        System.out.println();

        ShellSorter shellSorter=new  ShellSorter();
        shellSorter.setList(commons);
        comp=(o1, o2) -> o2.getMan().getFioForComp().compareTo(o1.getMan().getFioForComp());
        shellSorter.sort(comp);
        for (int i = 0; i < insertionSorter.getList().length; i++) {
            System.out.println(Array.get(insertionSorter.getList(), i));
        }
        System.out.println();

    }
    @Test
    public void readCsv() throws IOException {

        RepoMethods repoMethods=new RepoMethods();
        Common[] commons=new Common[]{common1,common2,common3};
        repoMethods.setList(commons);
        Long count=(long)repoMethods.getList().length;
        count++;
        CsvAdd csvAdd = new CsvAddImpl();
        File csv = new File("src/main/java/laba3/file/contracts.csv");
        csvAdd.readCsv(csv, repoMethods, count);
        Common[]commons1=repoMethods.getList();
        assertEquals("Anisimov Paul Sergeevich", commons1[3].getMan().getFio());
        assertEquals(8,repoMethods.getList().length);
        for (int i = 0; i < repoMethods.getList().length; i++) {
            System.out.println(Array.get(repoMethods.getList(), i));
        }
        System.out.println();
    }
}