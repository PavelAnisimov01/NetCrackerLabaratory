package laba2.Search;

import laba1.common.Common;
import laba1.repository.RepoMethods;


import java.util.Arrays;
import java.util.function.Predicate;
/**
 * Класс поиск со свойствами <b>commons</.
 * @autor Анисимов Павел
 */
public class SearchMethods extends RepoMethods {

    /**
     * Функция получения значения поля
     * @return возвращает критерий поиска по возрасту человека
     */
    public Predicate<Common> AgeSearch(Integer age) {
        return p -> p.getMan().getAge().equals(age);
    }
    /**
     * Функция получения значения поля
     * @return возвращает критерий поиска по FiO человека
     */
    public Predicate<Common> FioSearch(String fio) {
        return p -> p.getMan().getFio().equals(fio);
    }
    /**
     * Функция получения значения поля
     * @return возвращает критерий поиска по ID человека
     */
    public Predicate<Common> IdPersonSearch(Long id) {
        return p -> p.getMan().getID().equals(id);
    }
    /**
     * Функция получения значения поля
     * @return возвращает критерий поиска по ID контракта
     */
    public Predicate<Common> IdSearch(Long id) {
        return p -> p.getID().equals(id);
    }
    /**
     * Функция получения значения поля
     * @return возвращает критерий поиска по дате рождения человека
     */
    public Predicate<Common> DateOfBirthSearch(String dateBirth) {
        return p -> p.getMan().getDateOfBirthday().equals(dateBirth);
    }
    /**
     * Функция получения значения поля
     * @return возвращает критерий поиска по серии и номеру паспорта человека
     */
    public Predicate<Common> SeriyAndNumberSearch(String seriyAndNumber) {
        return p -> p.getMan().getDateOfPassport().equals(seriyAndNumber);
    }
    /**
     * Функция получения значения поля
     * @return возвращает критерий поиска по полу человека
     */
    public Predicate<Common> GenderSearch(String gender) {
        return p -> p.getMan().getGender().equals(gender);
    }
    /**
     * Функция получения значения поля
     * @return возвращает критерий поиска по дате начала контракта
     */

    public Predicate<Common> DateOfStartContractSearch(String dateOfStartContract) {
        return p -> p.getDateOfStartofContract().equals(dateOfStartContract);

    }
    /**
     * Функция получения значения поля
     * @return возвращает критерий поиска по дате окончания контракта
     */
    public Predicate<Common> DateOfEndContractSearch(String dateOfEndContract) {
        return p -> p.getDateOfEndofContract().equals(dateOfEndContract);

    }
    /**
     * Функция получения значения поля
     * @return возвращает критерий поиска по номеру контракта
     */
    public Predicate<Common> NumberOfContractSearch(Long numberOfContract) {
        return p -> p.getNumberOfContract().equals(numberOfContract);

    }
    /**
     * Функция  сортировки вставкой с критерием {@link Predicate<Common>#сondition}
     *  @param condition - критерий поиска
     * @return объект, который совпадает с поиском
     */
    public SearchMethods find(Predicate<Common> condition) {
        SearchMethods newRepo = new SearchMethods();
        Arrays.stream(this.getList()).forEach(common -> {
            if (
                    (common != null && condition.test(common))) newRepo.setList(newRepo.addCommon(common));
        });
        return newRepo;


    }
}

