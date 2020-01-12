package com.cm.MapAnalyze;

import java.util.*;

/**
 * @author chengawu
 * @date 4/4/2019 10:44 AM
 */
public class Demo {
    public enum DataType {
        VARCHAR, NUMBER, DATE, TIMESTAMP
    }

    public static void main(String[] args) {
        List<FieldAttr> fieldAttrList = new ArrayList<>();
        FieldAttr field1 = new FieldAttr(1,"aaa","ORA_GLOBAL","AttributeVarchar1");
        FieldAttr field2 = new FieldAttr(2,"bbb","ORA_CUSTOM","AttributeVarchar1");
        FieldAttr field3 = new FieldAttr(3,"ccc","ORA_CUSTOM","AttributeVarchar1");
        FieldAttr field4 = new FieldAttr(4,"ddd","ORA_CUSTOM","AttributeVarchar1");
        fieldAttrList.add(field1);
        fieldAttrList.add(field2);
        fieldAttrList.add(field3);
        fieldAttrList.add(field4);

        Map<String,Object> map = new HashMap<>();
        for (FieldAttr fieldAttr : fieldAttrList){
            String key = fieldAttr.getContextCode() + "_" + fieldAttr.getDbcolumnName();
            map.put(key,fieldAttr);
        }
        System.out.println(1111);
//        for (Map.Entry entry : map.entrySet()){
//            System.out.println(entry.getKey());
//            FieldAttr attr = (FieldAttr) entry.getValue();
//            System.out.println(attr.getName());
//        }

        for(Object obj : map.values()){
            FieldAttr attr = (FieldAttr) obj;
            System.out.println(attr.getName());
        }
    }

    static class FieldAttr{
        private int id;
        private String name;
        private String contextCode;
        private String dbcolumnName;

        public FieldAttr(int id, String name, String contextCode, String dbcolumnName) {
            this.id = id;
            this.name = name;
            this.contextCode = contextCode;
            this.dbcolumnName = dbcolumnName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getContextCode() {
            return contextCode;
        }

        public void setContextCode(String contextCode) {
            this.contextCode = contextCode;
        }

        public String getDbcolumnName() {
            return dbcolumnName;
        }

        public void setDbcolumnName(String dbcolumnName) {
            this.dbcolumnName = dbcolumnName;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
