package laba1.repository;

import laba1.common.Common;
import laba2.Sort.Sorter;

/**
 * Класс репозиторий методы со свойствами <b>list</b>  .
 * @autor Анисимов Павел
 */
public class RepoMethods implements RepoInterface{
    /** Поле list */
    protected Common[] list;

    /**
     * Функция определения базы данных
     *  @param list - база данных
     */
    public void setList(Common[] list) {
        this.list = list;
    }
    /**
     * Функция получения значения поля {@link RepoMethods#list}
     * @return возвращает значение списка из базы данных
     */
    public Common[] getList() {
        return list;
    }

    /**
     * Функция добавления одного из контрактов в базу данных
     *  @param common - контракт
     *  @return возвращает новый расширенный массив контрактов
     */
    @Override
    public Common[] addCommon(Common common) {
        Common[] newList;
        if (list == null) {
            newList = new Common[1];
            newList[0] = common;
        } else {
            newList = new Common[list.length + 1];
            System.arraycopy(list, 0, newList, 0, list.length);
            newList[list.length] = common;
        }
        return newList;
    }
    /**
     * Функция удаления одного из контрактов из базы данных
     *  @return возвращает новый суженный массив контрактов
     */
    @Override
    public Common[] deleteCommon(Long id) {
        int i = Integer.parseInt(String.valueOf(id));
        int k; int y=0;
        if (list != null) {
            for (int j = 0; j < list.length; j++) {
                if (Integer.parseInt(String.valueOf(list[j].getID())) == i) {
                    k = j; y=1;
                    if (k == 0) {
                        for (int t1 = 1; t1 < list.length; t1++) {
                            list[t1 - 1] = list[t1];
                        }
                    } else if (k == list.length - 1) {
                        list[k] = null;
                    } else {
                        for (int t1 = k; t1 < list.length - 1; t1++) {
                            list[t1] = list[t1 + 1];
                        }
                    }
                    break;
                }
            }
        }
        if (y==1) {
            Common[] newList;
            newList = new Common[list.length - 1];
            System.arraycopy(list, 0, newList, 0, newList.length);
            return newList;
        }
        else return list;
    }
    /**
     * Функция получения одного из контрактов из базы данных
     */
    @Override
    public void viewContract(Long id){
        int i = Integer.parseInt(String.valueOf(id));
        if (list != null) {
            for (Common common : list) {
                if (Integer.parseInt(String.valueOf(common.getID())) == i) {
                    System.out.println(common);
                    break;
                }

            }
        }
        else {
            System.out.println("Список пуст");}

    }

}