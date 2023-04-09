package laba3.impl;

import laba1.common.Common;
import laba1.repository.RepoMethods;

import java.io.File;
import java.io.IOException;
/**
 * Интерфейс Csv.
 * @autor Анисимов Павел
 */
public interface CsvAdd {
    Common[] readCsv(File pathToCsv, RepoMethods repoMethods, Long count) throws IOException;
}
