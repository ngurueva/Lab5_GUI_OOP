package L5_GUI.view;

import L5_GUI.data.*;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class MyTableModel extends AbstractTableModel {
    private PublishingHouse data;
    public MyTableModel(PublishingHouse publishingHouse){
        this.data = publishingHouse;
    }


    @Override
    public int getRowCount() {
        return data.getSizeList();
    }

    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Название";
            case 1: return "Автор";
            case 2: return "Год выпуска";
            case 3: return "Количестов страниц";
            case 4: return "Жанр";
            case 5: return "Учебная область";
            case 6: return "Номер выпуска";
        }
        return "";
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return data.getEdition(rowIndex).getTitle();
            case 1: return data.getEdition(rowIndex).getAuthor();
            case 2: return data.getEdition(rowIndex).getYear();
            case 3: return data.getEdition(rowIndex).getNumOfPages();
            case 4:{
                PrinteredEdition edition = data.getEdition(rowIndex);
                if (edition instanceof Book) {
                    return ((Book) edition).getGenre();
                }
                else {
                    return "-";
                }
            }
            case 5:{
                PrinteredEdition edition = data.getEdition(rowIndex);
                if (edition instanceof Textbook){
                    return ((Textbook)edition).getStudyArea();
                }
                else {
                    return "-";
                }
            }
            case 6: PrinteredEdition edition = data.getEdition(rowIndex);
                if (edition instanceof Magazine){
                    return ((Magazine)edition).getIssueNumber();
                }
                else {
                    return "-";
                }
        }
        return "-";
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        try {
            switch (columnIndex) {
                case 0:
                    data.getEdition(rowIndex).setTitle((String) aValue);
                    break;
                case 1:
                    data.getEdition(rowIndex).setAuthor((String) aValue);
                    break;
                case 2:
                    data.getEdition(rowIndex).setYear(Integer.parseInt((String) aValue));
                    break;
                case 3:
                    data.getEdition(rowIndex).setNumOfPages(Integer.parseInt((String) aValue));
                    break;
                case 4:
                    data.getEdition(rowIndex).setGenre((String) aValue);
                    break;
                case 5:
                    data.getEdition(rowIndex).setStudyArea((String) aValue);
                    break;
                case 6:
                    data.getEdition(rowIndex).setIssueNum(Integer.parseInt((String) aValue));
                    break;
            }
            fireTableCellUpdated(rowIndex, columnIndex);
        } catch (NumberFormatException ex){
            JDialog dialog = new JDialog(new Frame(), "Редактирование", true);
            dialog.add(new JLabel("   Введите корректное значение"));
            dialog.setSize(250, 100);
            dialog.setVisible(true);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return true;
            case 1: return true;
            case 2: return true;
            case 3: return true;
            case 4: return true;
            case 5: return true;
            case 6: return true;
        }
        return false;
    }

    public void delete(int[] index){
        if (index.length > 0){
            for (int i = index.length - 1; i >= 0; i--) {
                this.data.remove(index[i]);
            }
        }
        else {
            throw new IndexOutOfBoundsException();
        }
        fireTableDataChanged();
    }

    public ArrayList<Integer> search(String searchText) {
        ArrayList<Integer> searchRow = new ArrayList<>();
        for (int i = 0; i < data.getCount(); i++) {
            if (this.data.getEdition(i).getTitle().equals(searchText)){
                searchRow.add(i);
            }
            if (this.data.getEdition(i).getAuthor().equals(searchText)){
                searchRow.add(i);
            }
        }
        return searchRow;
    }

    public PublishingHouse getData() {
        return data;
    }

    public void sort(String option){
        data.sort(option);
        fireTableDataChanged();
    }
}
