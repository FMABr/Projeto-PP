package com.vitoriana.farma.gui.estoque;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.swing.RowFilter;
import javax.swing.table.AbstractTableModel;

import com.vitoriana.farma.model.Fornecedor;
import com.vitoriana.farma.model.Funcionario;
import com.vitoriana.farma.model.Item;
import com.vitoriana.farma.model.ItemCategoria;

public class ItemTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    private static final List<String> COLUNAS = Arrays.asList(
            new String[] { "Nome", "Categoria", "Localização", "Quantidade", "Preço", "Fornecedor", "Estoquista" });

    protected List<Item> tableData;
    protected String[] colunas;

    public ItemTableModel(List<Item> tableData) {
        super();
        this.tableData = tableData;
        this.colunas = new String[] { "Nome", "Categoria", "Localização", "Quantidade", "Preço", "Fornecedor",
                "Estoquista" };
    }

    public ItemTableModel(List<Item> tableData, String... colunas) {
        this.tableData = Collections.synchronizedList(tableData);

        Set<String> colunasUnicas = new LinkedHashSet<String>(7, 1);
        for (var coluna : colunas) {
            if (ItemTableModel.COLUNAS.contains(coluna)) {
                colunasUnicas.add(coluna);
            } else {
                throw new IllegalArgumentException(coluna + " não é uma coluna válida de Item.");
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
        Item linha = tableData.get(rowIndex);
        String coluna = colunas[columnIndex];

        Fornecedor fornecedor;
        Funcionario estoquista;
        String value = switch (coluna) {
            case "Nome" -> linha.getNome();
            case "Categoria" -> linha.getCategoria().name();
            case "Localização" -> linha.getLocalizacao();
            case "Quantidade" -> String.valueOf(linha.getQuantidade());
            case "Preço" -> String.valueOf(linha.getPreco());
            case "Fornecedor" -> ((fornecedor = linha.getFornecedor()) != null ? fornecedor.getNome() : "");
            case "Estoquista" -> ((estoquista = linha.getEstoquista()) != null ? estoquista.getNome() : "");

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

    public List<Item> getTableData() {
        return tableData;
    }

    public Item getRowData(int rowIndex) {
        return this.tableData.get(rowIndex);
    }

    public void refresh() {
        super.fireTableDataChanged();
    }

    public RowFilter<ItemTableModel, Integer> filtrar(String nome, String localizacao, String fornecedor,
            ItemCategoria categoria) {
        RowFilter<ItemTableModel, Integer> filtro = RowFilter.andFilter(List.of(
                // Não deveriamos usar os indices fixos,
                // a classe pode ser instanciada com as colunas em qualquer ordem
                RowFilter.regexFilter(nome, 0), RowFilter.regexFilter(localizacao, 2),
                RowFilter.regexFilter(fornecedor, 5),
                categoria == null ? null : RowFilter.regexFilter(categoria.name(), 1)));

        return filtro;
    }

    public RowFilter<ItemTableModel, Integer> filtrar(String nome, String localizacao, String fornecedor) {
        RowFilter<ItemTableModel, Integer> filtro = RowFilter.andFilter(List.of(
                // Não deveriamos usar os indices fixos,
                // a classe pode ser instanciada com as colunas em qualquer ordem
                RowFilter.regexFilter(nome, 0), RowFilter.regexFilter(localizacao, 2),
                RowFilter.regexFilter(fornecedor, 5)));

        return filtro;
    }
}
