package com.vitoriana.farma.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.vitoriana.farma.model.Entidade;

public class SerializationService<E extends Entidade> {

    private String diretorio;

    public SerializationService(String diretorio) {
        this.diretorio = diretorio;
        
    }
    
    public int quantidade() {
        int qtd = new File(this.diretorio).list().length;

        return qtd;
    }

    public boolean serializar(E entidade) {
        int id = entidade.getId();

        try (var fileOutStream = new FileOutputStream(getCaminho(id));
                var objOutStream = new ObjectOutputStream(fileOutStream);) {

            objOutStream.writeObject(entidade);

            return true;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    public List<E> desserializarTodos() {
        List<E> entidades = new ArrayList<>();

        try (Stream<Path> paths = Files.walk(Paths.get(diretorio))) {
            paths.filter(Files::isRegularFile).forEach(path -> entidades.add(this.desserializar(path)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return entidades;
    }

    public E desserializar(int id) {
        return desserializar(Path.of(getCaminho(id)));
    }

    @SuppressWarnings("unchecked")
    private E desserializar(Path path) {
        File file = path.toFile();
        E entidade = null;

        if (file.isFile() && file.canRead()) {
            try (var fileInStream = new FileInputStream(path.toString());
                    var objInStream = new ObjectInputStream(fileInStream);) {

                entidade = (E) objInStream.readObject();

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }

        return entidade;
    }

    public boolean remover(E entidade) throws FileNotFoundException {
        int id = entidade.getId();

        File file = new File(getCaminho(id));

        if (!file.exists())
            throw new FileNotFoundException("A Entidade " + entidade + " não existe.");

        if (file.delete()) {
            System.out.println("Entidade " + entidade + " deletada com sucesso.");
            return true;
        } else {
            return false;
        }
    }

    private String getCaminho(int id) {
        return this.diretorio + "/" + String.valueOf(id);
    }

    public static <T extends Entidade> SerializationService<T> of(Class<T> type) {
        return new SerializationService<T>(type.getSimpleName());
    }
}
