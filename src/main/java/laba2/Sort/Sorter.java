package laba2.Sort;

import laba1.common.Common;
import laba1.repository.RepoMethods;

import java.util.Comparator;
/**
 * Класс сортировщик со свойствами <b>commons</
 * @autor Анисимов Павел
 */

public class Sorter extends RepoMethods {

    public Comparator<Common> AgeComp(){
        return (o1, o2) -> o2.getMan().getAge().compareTo(o1.getMan().getAge());

    }
    /**
     * Функция получения значения поля
     * @return возвращает критерий сортировки по FIO
     */
    public Comparator<Common> FioComp(){
        return (o1, o2) -> o2.getMan().getFioForComp().compareTo(o1.getMan().getFioForComp());

    }
    /**
     * Функция получения значения поля
     * @return возвращает критерий сортировки по ID человека
     */
    public Comparator<Common> IdPersonComp(){
        return (o1, o2) -> o2.getMan().getID().compareTo(o1.getMan().getID());

    }
    /**
     * Функция получения значения поля
     * @return возвращает критерий сортировки по номеру контракта
     */
    public Comparator<Common> NumberOfContractComp(){
        return (o1, o2) -> o2.getNumberOfContract().compareTo(o1.getNumberOfContract());
    }
    /**
     * Функция получения значения поля
     * @return возвращает критерий сортировки по дате начала контракта
     */
    public Comparator<Common> getDateOfStartofContractComp(){
        return (o1, o2) -> o2.getDateOfStartofContractForComp().compareTo(o1.getDateOfStartofContractForComp());
    }
    /**
     * Функция получения значения поля
     * @return возвращает критерий сортировки по дате окончания контракта
     */
    public Comparator<Common> getdateOfEndofContractComp(){
        return (o1, o2) -> o2.getDateOfEndofContractForComp().compareTo(o1.getDateOfEndofContractForComp());
    }
    /**
     * Функция получения значения поля
     * @return возвращает критерий сортировки по ID контракта
     */
    public Comparator<Common> IdComp(){
        return (o1, o2) -> o2.getID().compareTo(o1.getID());

    }
}
