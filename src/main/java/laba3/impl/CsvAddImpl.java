package laba3.impl;

import laba1.common.Common;
import laba1.common.Man;
import laba1.contracts.Internet;
import laba1.contracts.Mobile;
import laba1.contracts.Tele;
import laba1.repository.RepoMethods;
import java.io.*;
/**
 * Класс CsvAddImpl,наследующий репометоды, имплементирующий CsvAdd.
 * @autor Анисимов Павел
 */
public class CsvAddImpl extends RepoMethods implements CsvAdd {
    /**
     * Функция получения значения поля
     * @return возвращает базу данных
     * @param pathToCsv - файл
     * @param repoMethods - база данных
     * @param count - счётчик id
     */
@Override
    public Common[] readCsv(File pathToCsv,RepoMethods repoMethods,Long count) throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));
        Common common;
        String line;

        while ((line = csvReader.readLine()) != null) {
            if ((common = parseLine(line,count)) != null) {
                repoMethods.setList(repoMethods.addCommon(common));
                count++;
            }
        }
     return repoMethods.getList();
    }
    /**
     * Функция получения значения поля
     * @return возвращает контракт
     * @param line - строка
     * @param count - счётчик id
     */

   public Common parseLine(String line,Long count){
       String[] splitLine=line.split(";");
       Common common=parseCommonInfo(splitLine[6],splitLine[7]);
       Man man=new Man();
       man.setFio(splitLine[0]);
       man.setGender(splitLine[1]);
       man.setDateOfBirthday(splitLine[2]);
       man.setSeriyAndNumberOfPassport(splitLine[3]);
       man.setID(count);
       common.setMan(man);
       common.setNumberOfContract(count);
       common.setDateOfEndofContract(splitLine[4]);
       common.setDateOfStartofContract(splitLine[5]);
       common.setID(count);
       return common;
   }
    /**
     * Функция получения значения поля
     * @return возвращает один из контрактов
     * @param contractType - тип контракта
     * @param contractInfo - дополнительная информация об контракте
     */

    public Common parseCommonInfo(String contractType, String contractInfo) {
        if (contractType.equalsIgnoreCase("Tele")) {
            return new Tele(contractInfo);
        } else if (contractType.equalsIgnoreCase("Internet")) {
            return new Internet(Integer.parseInt(contractInfo));
        } else {
            String[] mobileInfo = contractInfo.split(",");
            return new Mobile(
                    Integer.parseInt(mobileInfo[0]),
                    Integer.parseInt(mobileInfo[1]),
                    Integer.parseInt(mobileInfo[2]));
        }
    }
}
