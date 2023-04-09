package laba2.Sort;

import laba1.common.Common;


import java.util.Comparator;
/**
 * Класс пузырьковая сортировка со свойствами <b>commons</.
 * @autor Анисимов Павел
 */
public class BoubleSorter extends Sorter implements ISorter {
    /**
     * Функция пузырьковой сортировки с критерием {@link Comparator<Common>#comp}
     *  @param comp - критерий сортировки
     */
    @Override
    public void sort(Comparator<Common> comp) {
        for (int i = list.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (comp.compare(list[j], list[j + 1]) < 0) {
                    Common temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }
}
