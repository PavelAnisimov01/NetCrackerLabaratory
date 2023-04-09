import laba1.contracts.Internet;
import laba1.contracts.Mobile;
import laba1.contracts.Tele;
import laba1.repository.RepoMethods;
import laba2.Search.SearchMethods;
import laba2.Sort.BoubleSorter;
import laba2.Sort.InsertionSorter;
import laba2.Sort.ShellSorter;
import laba3.impl.CsvAddImpl;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Класс репозиторий, который выполняет функцию базы данных и выполняет метод main.
 * @autor Анисимов Павел
 */
public class Repo {
    /**
     * Функция main, которая реализует примитивную работу базы данных.
     */
    public static void main(String[] args) throws IOException {
        /* Создание списка объектов, который будет выполнять функцию хранения элементов базы данных */
        RepoMethods list=new RepoMethods();
        /* Создание объекта сканнер для ввода пользователем значений с клавиатуры*/
        Scanner scStr = new Scanner(System.in);
        Scanner scChislo = new Scanner(System.in);
        Scanner chislo = new Scanner(System.in);
        /* Создание счётчика для присваивания автоматически ID по контрактам*/
        Long count= 1L;
        /* Создание переменной для дальнейшего выхода из цикла по работе с базой данных*/
        int x = 1;
        /* Создание цикла, который позволяет повторять работу примитивной базы данных*/
        while (x != 0) {
            System.out.println("                    Введите нужную цифру:            ");
            System.out.println("1.Добавить контракт на мобильную связь в базу данных.");
            System.out.println("2.Добавить контракт на интернет в базу данных.");
            System.out.println("3.Добавить контракт на телевидение в базу данных.");
            System.out.println("4.Получить контракт из базы данных.");
            System.out.println("5.Удалить контракт из базу данных.");
            System.out.println("6.Отсортировать и получить массив по различным критериям.");
            System.out.println("7.Получить объект из базы данных по различным критериям.");
            System.out.println("8.Добавить контракты из файла.");
            System.out.println("9.Закончить работу с репозиторием.");
            /* Вызов одного из методов для работы с базой данных */
            switch (chislo.nextInt()) {
                /* Вызов метода, который добавляет контракт на мобильную связь в базу данных*/
                case (1) -> {
                    Mobile mobile=new Mobile();
                    mobile.setCommon(count,scStr,scChislo);
                    System.out.println("Введите количество минут по контракту");
                    mobile.setMinut(scChislo.nextInt());
                    System.out.println("Введите количество смс по контракта");
                    mobile.setSms(scChislo.nextInt());
                    System.out.println("Введите количество гигабайтов по контракту");
                    mobile.setGb(scChislo.nextInt());
                    list.setList(list.addCommon(mobile));
                    count++;
                }
                /* Вызов метода, который добавляет контракт на проводной интернет в базу данных*/
                case (2) -> {
                    Internet internet=new Internet();
                    internet.setCommon(count,scStr,scChislo);
                    System.out.println("Введите скорость интернета по контракту");
                    internet.setSpeedOfConnection(scChislo.nextInt());
                    list.setList(list.addCommon(internet));
                    count++;
                }
                /* Вызов метода, который добавляет контракт на телевидение в базу данных */
                case (3) -> {
                    Tele tele=new Tele();
                    tele.setCommon(count,scStr,scChislo);
                    System.out.println("Введите пакет каналов по контракту");
                    tele.setPacket(scStr.nextLine());
                    list.setList(list.addCommon(tele));
                    count++;
                }
                /* Вызов метода, который получает контракт по ID из базы данных*/
                case (4) -> {
                    Scanner sc1 = new Scanner(System.in);
                    System.out.println("Введите ID контракта, который хотите получить из базы данных");
                    Long id = sc1.nextLong();
                    list.viewContract(id);
                }

                /* Вызов метода, который удаляет контракт по ID из базы данных*/
                case (5) -> {
                    Scanner sc2=new Scanner(System.in);
                    System.out.println("Введите ID контракта, который хотите удалить из базы данных");
                    Long id = sc2.nextLong();
                    list.setList(list.deleteCommon(id));}

                /* Вызов метода, который переходит к циклу, который даёт возможность по различным критериям отсортировать и получить из базы данных список объектов*/
                case (6) -> {
                    int y=1;

                    while (y != 0) {
                        System.out.println("                Выберите критерий сортировки:        ");
                        System.out.println("                    Введите нужную цифру:            ");
                        System.out.println("                1.Отсортировать по ID контракта.");
                        System.out.println("                2.Отсортировать по ID человека.");
                        System.out.println("                3.Отсортировать по фамилии,имени,отчеству человека.");
                        System.out.println("                4.Отсортировать по возрасту человека.");
                        System.out.println("                5.Отсортировать по дате начала контракта.");
                        System.out.println("                6.Отсортировать по дате окончания контракта.");
                        System.out.println("                7.Отсортировать по номеру контракта.");
                        System.out.println("                8.Закончить сортировку.");

                        switch (chislo.nextInt()) {
                            /* Вызов метода, который сортирует контракты по ID контракта*/
                            case (1) -> {
                                InsertionSorter insertionSort=new InsertionSorter();
                                insertionSort.setList(list.getList());
                                insertionSort.sort(insertionSort.IdComp());

                                for (int i = 0; i < insertionSort.getList().length; i++) {
                                    System.out.println(Array.get(insertionSort.getList(), i));
                                }
                                System.out.println();
                            }
                            /* Вызов метода, который сортирует контракты по ID человека*/
                            case (2) -> {
                                BoubleSorter boubleSort=new BoubleSorter();
                                boubleSort.setList(list.getList());
                                boubleSort.sort(boubleSort.IdPersonComp());
                                for (int i = 0; i < boubleSort.getList().length; i++) {
                                    System.out.println(Array.get(boubleSort.getList(), i));
                                }
                                System.out.println();
                            }
                            /* Вызов метода, который сортирует контракты по FIO человека*/
                            case (3) -> {
                                ShellSorter shellSort=new ShellSorter();
                                shellSort.setList(list.getList());
                                shellSort.sort(shellSort.FioComp());
                                for (int i = 0; i < shellSort.getList().length; i++) {
                                    System.out.println(Array.get(shellSort.getList(), i));
                                }
                                System.out.println();
                            }
                            /* Вызов метода, который сортирует контракты по возрасту человека*/
                            case (4) -> {
                                InsertionSorter insertionSort=new InsertionSorter();
                                insertionSort.setList(list.getList());
                                insertionSort.sort(insertionSort.AgeComp());

                                for (int i = 0; i < insertionSort.getList().length; i++) {
                                    System.out.println(Array.get(insertionSort.getList(), i));
                                }
                                System.out.println();
                            }
                            /* Вызов метода, который сортирует контракты по дате начала контракта*/
                            case (5) -> {
                                BoubleSorter boubleSort=new BoubleSorter();
                                boubleSort.setList(list.getList());
                                boubleSort.sort(boubleSort.getDateOfStartofContractComp());
                                for (int i = 0; i < boubleSort.getList().length; i++) {
                                    System.out.println(Array.get(boubleSort.getList(), i));
                                }
                                System.out.println();
                            }
                            /* Вызов метода, который сортирует контракты по дате окончания контракта*/
                            case (6) -> {
                                ShellSorter shellSort=new ShellSorter();
                                shellSort.setList(list.getList());
                                shellSort.sort(shellSort.getdateOfEndofContractComp());
                                for (int i = 0; i < shellSort.getList().length; i++) {
                                    System.out.println(Array.get(shellSort.getList(), i));
                                }
                                System.out.println();
                            }
                            /* Вызов метода, который сортирует контракты по номеру контракта*/
                            case (7) -> {
                                InsertionSorter insertionSort=new InsertionSorter();
                                insertionSort.setList(list.getList());
                                insertionSort.sort(insertionSort.NumberOfContractComp());

                                for (int i = 0; i < insertionSort.getList().length; i++) {
                                    System.out.println(Array.get(insertionSort.getList(), i));
                                }
                                System.out.println();
                            }
                            /* Вызов метода, который заканчивает сортировку*/
                            case (8) -> {
                                y = 0;
                                System.out.println("Выход из сортировки произведён успешно");
                            }
                            default ->
                                    System.out.println("Вы ввели значение, на которое у базы данных нет функционала, введите другое значение пожалуйста");
                        }
                    }


                }
                /* Вызов метода, который переходит к циклу, который даёт возможность по различным критериям получить из базы данных тот или иной объект*/
                case (7) -> {
                    SearchMethods prst = new SearchMethods();
                    prst.setList(list.getList());
                    int z=1;
                    while (z != 0) {
                        System.out.println("                Выберите критерий поиска по объектам:        ");
                        System.out.println("                    Введите нужную цифру:            ");
                        System.out.println("                1.Найти по ID контракта.");
                        System.out.println("                2.Найти по ID человека.");
                        System.out.println("                3.Найти по фамилии,имени,отчеству человека.");
                        System.out.println("                4.Найти по возрасту человека.");
                        System.out.println("                5.Найти по дате начала контракта.");
                        System.out.println("                6.Найти по дате окончания контракта.");
                        System.out.println("                7.Найти по номеру контракта.");
                        System.out.println("                8.Найти по гендеру человека.");
                        System.out.println("                9.Найти по дате рождения человека.");
                        System.out.println("                10.Найти по серии и номеру паспорта.");
                        System.out.println("                11.Закончить поиск.");

                        switch (chislo.nextInt()) {
                            /* Вызов метода, который ищет контракты по ID контракта*/
                            case(1) -> {
                                System.out.println("Введите ID контракта");
                                SearchMethods prst1=prst.find(prst.IdSearch(scChislo.nextLong()));
                                for(int i=0;i<prst1.getList().length;i++){
                                    System.out.println(Array.get(prst1.getList(), i));
                                }
                                System.out.println();
                            }
                            /* Вызов метода, который ищет контракты по ID человека*/
                            case(2) -> {
                                System.out.println("Введите ID человека");
                                SearchMethods prst1=prst.find(prst.IdPersonSearch(scChislo.nextLong()));
                                for(int i=0;i<prst1.getList().length;i++){
                                    System.out.println(Array.get(prst1.getList(), i));
                                }
                                System.out.println();
                            }
                            /* Вызов метода, который ищет контракты по FIO человека*/
                            case(3) -> {
                                System.out.println("Введите FIO человека");
                                SearchMethods prst1=prst.find(prst.FioSearch(scStr.nextLine()));
                                for(int i=0;i<prst1.getList().length;i++){
                                    System.out.println(Array.get(prst1.getList(), i));
                                }
                                System.out.println();
                            }
                            /* Вызов метода, который ищет контракты по возрасту человека*/
                            case(4) -> {
                                System.out.println("Введите возраст человека");
                                SearchMethods prst1=prst.find(prst.AgeSearch(scChislo.nextInt()));
                                for(int i=0;i<prst1.getList().length;i++){
                                    System.out.println(Array.get(prst1.getList(), i));
                                }
                                System.out.println();
                            }
                            /* Вызов метода, который ищет контракты по дате начала контракта*/
                            case(5) -> {
                                System.out.println("Введите дату начала контракта");
                                SearchMethods prst1=prst.find(prst.DateOfStartContractSearch(scStr.nextLine()));
                                for(int i=0;i<prst1.getList().length;i++){
                                    System.out.println(Array.get(prst1.getList(), i));
                                }
                                System.out.println();
                            }
                            /* Вызов метода, который ищет контракты по дате окончания контракта*/
                            case(6) -> {
                                System.out.println("Введите дату окончания контракта");
                                SearchMethods prst1=prst.find(prst.DateOfEndContractSearch(scStr.nextLine()));
                                for(int i=0;i<prst1.getList().length;i++){
                                    System.out.println(Array.get(prst1.getList(), i));
                                }
                                System.out.println();
                            }
                            /* Вызов метода, который ищет контракты по номеру контракта*/
                            case(7) -> {
                                System.out.println("Введите номер контракта");
                                SearchMethods prst1=prst.find(prst.NumberOfContractSearch(scChislo.nextLong()));
                                for(int i=0;i<prst1.getList().length;i++){
                                    System.out.println(Array.get(prst1.getList(), i));
                                }
                                System.out.println();
                            }
                            /* Вызов метода, который ищет контракты по полу человека*/
                            case(8) -> {
                                System.out.println("Введите пол человека");
                                SearchMethods prst1=prst.find(prst.GenderSearch(scStr.nextLine()));
                                for(int i=0;i<prst1.getList().length;i++){
                                    System.out.println(Array.get(prst1.getList(), i));
                                }
                                System.out.println();
                            }
                            /* Вызов метода, который ищет контракты по дате рождения человека*/
                            case(9) -> {
                                System.out.println("Введите дату рождения человека");
                                SearchMethods prst1=prst.find(prst.DateOfBirthSearch(scStr.nextLine()));
                                for(int i=0;i<prst1.getList().length;i++){
                                    System.out.println(Array.get(prst1.getList(), i));
                                }
                                System.out.println();

                            }
                            /* Вызов метода, который ищет контракты по серии и номеру паспорта человека*/
                            case(10) -> {

                                System.out.println("Введите серию и номер паспорта человека");
                                SearchMethods prst1=prst.find(prst.SeriyAndNumberSearch(scStr.nextLine()));
                                for(int i=0;i<prst1.getList().length;i++){
                                    System.out.println(Array.get(prst1.getList(), i));
                                }
                                System.out.println();

                            }

                /* Вызов метода, который завершает работу поиска по различным критериям*/
                            case (11) -> {
                                z = 0;
                                System.out.println("Выход из поиска произведён успешно");
                            }
                            default ->
                                    System.out.println("Вы ввели значение, на которое у базы данных нет функционала, введите другое значение пожалуйста");
                        }
                    }
                }
                /* Вызов метода, который добавляет контракты из файла*/
                case (8) ->{
                    CsvAddImpl csvAdd=new CsvAddImpl();
                    File csv = new File("src/main/java/laba3/file/contracts.csv");
                    list.setList(csvAdd.readCsv(csv,list,count));
                    count= (long) list.getList().length;
                    count++;

                }


                /* Вызов метода, который завершает работу базы данных*/
                case (9) ->{
                    x=0;
                    System.out.println("Выход из репозитория произведён успешно");
                }
                default ->
                        System.out.println("Вы ввели значение, на которое у базы данных нет функционала, введите другое значение пожалуйста");

            }
        }
    }
}