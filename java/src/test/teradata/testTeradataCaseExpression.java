package test.teradata;
/*
 * Date: 2010-10-13
 * Time: 16:39:18
 */

import junit.framework.TestCase;
import gudusoft.gsqlparser.TGSqlParser;
import gudusoft.gsqlparser.EDbVendor;

public class testTeradataCaseExpression extends TestCase {

    public void test1(){
        TGSqlParser sqlparser = new TGSqlParser(EDbVendor.dbvteradata);
        sqlparser.sqlfilename = "c:\\prg\\gsqlparser\\Test\\TestCases\\teradata\\verified\\case_expression.sql";
        assertTrue(sqlparser.parse() == 0);
    }

}
