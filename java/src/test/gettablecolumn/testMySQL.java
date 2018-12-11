package test.gettablecolumn;

import demos.gettablecolumns.TGetTableColumn;
import gudusoft.gsqlparser.EDbVendor;
import junit.framework.TestCase;


public class testMySQL extends TestCase {

    static void doTest(String inputQuery, String desireResult){
        TGetTableColumn getTableColumn = new TGetTableColumn(EDbVendor.dbvmysql);
        getTableColumn.isConsole = false;
        getTableColumn.showTableEffect = false;
        getTableColumn.showColumnLocation = false;
        getTableColumn.showTreeStructure = false;
        getTableColumn.showDatatype = true;
        getTableColumn.runText(inputQuery);
       // System.out.println(getTableColumn.outList.toString().trim());
        assertTrue(getTableColumn.outList.toString().trim().equalsIgnoreCase(desireResult));
    }

    public static void testStringLiteral() {
        doTest("SELECT 1 FROM table1 WHERE table1.field1 = \"Z\" or table.field1 = 'X'",
                "Tables:\n" +
                        "table1\n" +
                        "Fields:\n" +
                        "table1.field1");
    }

    public static void testAlterTableDropColumn() {
        doTest("alter table test_1 drop column new_column23;",
                "Tables:\n" +
                        "test_1\n" +
                        "Fields:\n" +
                        "test_1.new_column23");
    }

    public static void testAlterTableChangeColumn() {
        doTest("alter table test_1 change column  id id123 varchar(1000) not null;",
                "Tables:\n" +
                        "test_1\n" +
                        "Fields:\n" +
                        "test_1.id\n" +
                        "test_1.id123");
    }

    public static void testAlterTableAddPrimaryKeyConstraint() {
        doTest("alter table test_3 add constraint pk primary key(id);",
                "Tables:\n" +
                        "test_3\n" +
                        "Fields:\n" +
                        "test_3.id");
    }

    public static void testAlterTableAddForeignKeyConstraint() {
        doTest("alter table test_3 add constraint fk foreign key(id) references city(id);",
                "Tables:\n" +
                        "city\n" +
                        "test_3\n" +
                        "Fields:\n" +
                        "city.id\n" +
                        "test_3.id");
    }

    public static void testCreateTablePrimaryKeyConstraint() {
        doTest("CREATE TABLE customers\n" +
                        "( customer_id int NOT NULL,\n" +
                        "  last_name char(50) NOT NULL,\n" +
                        "  first_name char(50) NOT NULL,\n" +
                        "  favorite_website char(50),\n" +
                        "  CONSTRAINT customers_pk PRIMARY KEY (customer_id));",
                "Tables:\n" +
                        "customers\n" +
                        "Fields:\n" +
                        "customers.customer_id\n" +
                        "customers.customer_id:int\n" +
                        "customers.favorite_website:char:50\n" +
                        "customers.first_name:char:50\n" +
                        "customers.last_name:char:50");
    }

    public static void testCreateTableUniqueKeyConstraint() {
        doTest("CREATE TABLE contacts\n" +
                        "( contact_id INT(11) PRIMARY KEY AUTO_INCREMENT,\n" +
                        "  reference_number INT(11) NOT NULL,\n" +
                        "  last_name VARCHAR(30) NOT NULL,\n" +
                        "  first_name VARCHAR(25),\n" +
                        "  birthday DATE,\n" +
                        "  CONSTRAINT contacts_unique UNIQUE (contact_id));",
                "Tables:\n" +
                        "contacts\n" +
                        "Fields:\n" +
                        "contacts.birthday:date\n" +
                        "contacts.contact_id\n" +
                        "contacts.contact_id:int:11\n" +
                        "contacts.first_name:varchar:25\n" +
                        "contacts.last_name:varchar:30\n" +
                        "contacts.reference_number:int:11");
    }

    public static void testAlterTableAddConstraintUniqueKey() {
        doTest("ALTER TABLE contacts\n" +
                        "ADD CONSTRAINT contact_name_unique UNIQUE (last_name, first_name);",
                "Tables:\n" +
                        "contacts\n" +
                        "Fields:\n" +
                        "contacts.first_name\n" +
                        "contacts.last_name");
    }
}
