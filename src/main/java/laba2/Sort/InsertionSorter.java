package laba2.Sort;

import laba1.common.Common;

import java.util.Comparator;
/**
 * Класс сортировка вставкой со свойствами <b>commons</.
 * @autor Анисимов Павел
 */
public class InsertionSorter extends Sorter implements ISorter {
    /**
     * Функция  сортировки вставкой с критерием {@link Comparator<Common>#comp}
     *  @param comp - критерий сортировки
     */
    @Override
    public void sort(Comparator<Common> comp){

        for (int left = 0; left < list.length; left++) {
            // Вытаскиваем значение элемента
            Common value = list[left];
            // Перемещаемся по элементам, которые перед вытащенным элементом
            int i = left - 1;
            for (; i >= 0; i--) {
                // Если вытащили значение меньшее — передвигаем больший элемент дальше
                if (comp.compare(value , list[i]) > 0) {
                    list[i + 1] = list[i];
                } else {
                    // Если вытащенный элемент больше — останавливаемся
                    break;
                }
            }
            // В освободившееся место вставляем вытащенное значение
            list[i + 1] = value;
        }
    }


}
