package com.vitoriana.farma.gui.funcionarios;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.swing.RowFilter;
import javax.swing.table.AbstractTableModel;

import com.vitoriana.farma.model.Funcionario;

public class FuncionarioTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    private static final List<String> COLUNAS = Arrays.asList(new String[] { "Nome", "Matricula", "Função" });

    protected List<Funcionario> tableData;
    protected String[] colunas;

    public FuncionarioTableModel(List<Funcionario> tableData) {
        super();
        this.tableData = tableData;
        this.colunas = new String[] { "Nome", "Matricula", "Função" };
    }

    public FuncionarioTableModel(List<Funcionario> tableData, String... colunas) {
        this.tableData = Collections.synchronizedList(tableData);

        Set<String> colunasUnicas = new LinkedHashSet<String>(3, 1);
        for (var coluna : colunas) {
            if (FuncionarioTableModel.COLUNAS.contains(coluna)) {
                colunasUnicas.add(coluna);
            } else {
                throw new IllegalArgumentException(coluna + " não é uma coluna válida de Funcionario.");
            }
        }

        this.colunas = new String[colunasUnicas.size()];
        int index = 0;

        for (var coluna : colunasUnicas) {
            this.colunas[index] = coluna;
            index++;
        }
    }

    @Override
    public int getRowCount() {
        return tableData.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Funcionario linha = tableData.get(rowIndex);
        String coluna = colunas[columnIndex];

        String value = switch (coluna) {
            case "Nome" -> linha.getNome();
            case "Matricula" -> linha.getMatricula();
            case "Função" -> linha.isAdministrador() ? "Gerente" : "Funcionario";

            default -> throw new IllegalArgumentException("Coluna não esperada: " + coluna);
        };

        return value;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public List<Funcionario> getTableData() {
        return tableData;
    }

    public Funcionario getRowData(int rowIndex) {
        return this.tableData.get(rowIndex);
    }

    public void refresh() {
        super.fireTableDataChanged();
    }

    public RowFilter<FuncionarioTableModel, Integer> filtrar(String nome, String matricula, boolean admin) {
        RowFilter<FuncionarioTableModel, Integer> filtro = new RowFilter<FuncionarioTableModel, Integer>() {
            @Override
            public boolean include(Entry<? extends FuncionarioTableModel, ? extends Integer> entry) {
                for (int i = 0; i < entry.getValueCount(); i++) {
                    System.out.println(entry.getValue(i));
                }
                return false;
            }
        };

        return filtro;
    }
}
