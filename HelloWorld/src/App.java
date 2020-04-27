import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        DataLoader dl = new DataLoader();
        dl.load("/Users/mario/Downloads/patients1.csv");
        System.out.println(dl.getDataFrame().toString());
    }
}

class DataLoader {
    private DataFrame dataFrame;

    public DataFrame getDataFrame(){
        return this.dataFrame;
    }
    public DataFrame load(String path) {
        File file = new File(path);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("BufferedReader or FileReader declaration fail");
            return this.dataFrame;
        }

        String line = "";
        this.dataFrame = new DataFrame();
        //1. first line
        try {
            line = br.readLine();
            if(line == null) throw new IOException();
            String[] str = line.split(",");
            for (String s: str){
                if(s == null || s.length() == 0) throw new IOException();
                this.dataFrame.getColumns().add(new Column(s));
            }
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("the file doesn't have column name");
            try {
                br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return this.dataFrame;
        }

        while(true){
            try {
                if ((line = br.readLine()) == null) break;
                String[] str = line.split(",");
                for (int i = 0; i < this.dataFrame.getColumns().size(); i++){
                    this.dataFrame.getColumns().get(i).addRowValue(str[i]);
                }
            } catch (IOException e) {
                //e.printStackTrace();
                System.out.println("read line failed");
                try {
                    br.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                return this.dataFrame;
            }
        }
        return this.dataFrame;
    }
}

class DataFrame {
    private List<Column> columns;

    public DataFrame() {
        this.columns = new ArrayList<>();
    }

    public List<Column> getColumns(){
        return this.columns;
    }

    public List<String> getColumnNames() {
        checkColumnIsNull();
        return this.columns.stream().map(Column::getName).collect(Collectors.toList());
    }

    public int getRowCount() {
        checkColumnIsNull();
        return this.columns == null ? 0 : this.columns.size();
    }

    public String getValue(String columnName, int row) throws Exception {
        checkColumnIsNull();
        return this.columns.get(insertedIdx(columnName)).getRowValue(row);
    }

    public void putValue(String columnName, int row, String value) throws Exception {
        checkColumnIsNull();
        this.columns.get(insertedIdx(columnName)).setRowValue(row, value);
    }

    public void addValue(String columnName, String value) throws Exception {
        checkColumnIsNull();
        this.columns.get(insertedIdx(columnName)).addRowValue(value);
    }

    private int insertedIdx(String columnName) throws Exception {
        int idx = 0;
        for (; idx < this.columns.size(); idx++) {
            if (this.columns.get(idx).getName().equals(columnName))
                break;
        }
        if (idx >= this.columns.size()) throw new Exception("there is no column named " + columnName + "in DataFrame");
        return idx;
    }

    private void checkColumnIsNull() {
        if (this.columns == null)
            this.columns = new ArrayList<>();
    }

    @Override
    public String toString(){
        checkColumnIsNull();
        StringBuilder sb = new StringBuilder();
        for(Column c: this.columns){
            sb.append(c.getName()).append(" ");
        }
        sb.append("\n");
        for (int row = 0; row < this.columns.get(0).getSize(); row++) {
            for (Column c: this.columns) {
                sb.append(c.getRowValue(row)).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

class Column {
    private String name;
    private List<String> rows;

    public Column(String name){
        this.name = name;
        this.rows = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getSize() {
        return this.rows.size();
    }

    public String getRowValue(int rowIdx) {
        return this.rows.get(rowIdx);
    }

    public void setRowValue(int rowIdx, String rowStr) {
        // check the whether row inserted is greater than current arraysList's size.
        if (rowIdx >= this.rows.size())
            return;
        this.rows.set(rowIdx, rowStr);
    }

    public void addRowValue(String rowStr) {
        if (this.rows == null)
            this.rows = new ArrayList<>();
        this.rows.add(rowStr);
    }
}