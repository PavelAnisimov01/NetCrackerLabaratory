package laba1.repository;

import laba1.common.Common;
/**
 * Интерфейс репозитория.
 * @autor Анисимов Павел
 */
public interface RepoInterface {
     Common[] addCommon(Common common);
     Common[] deleteCommon(Long id);
     void viewContract(Long id);


}
