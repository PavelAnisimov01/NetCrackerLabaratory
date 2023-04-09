package laba2.Sort;

import laba1.common.Common;

import java.util.Comparator;
/**
 * Класс сортировка Шелла со свойствами <b>commons</.
 * @autor Анисимов Павел
 */
public class ShellSorter extends Sorter implements ISorter {
    /**
     * Функция  сортировки Шелла с критерием {@link Comparator<Common>#comp}
     *  @param comp - критерий сортировки
     */
    @Override
    public void sort(Comparator<Common> comp){
        int gap = list.length / 2;
// Пока разница между элементами есть
        while (gap >= 1) {
            for (int right = 0; right < list.length; right++) {
                // Смещаем правый указатель, пока не сможем найти такой, что
                // между ним и элементом до него не будет нужного промежутка
                for (int c = right - gap; c >= 0; c -= gap) {
                    if (comp.compare(list[c] , list[c + gap]) < 0) {

                        Common temp = list[c];
                        list[c] = list[c+gap];
                        list[c+gap] = temp;
                    }
                }
            }
            // Пересчитываем разрыв
            gap = gap / 2;
        }
    }
}
