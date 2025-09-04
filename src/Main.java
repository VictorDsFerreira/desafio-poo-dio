import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
      Curso curso1 = new Curso();
      curso1.setTitulo("curso java");
      curso1.setDescricao("descri curso java");
      curso1.setCargaHoraria(8);

      Curso curso2 = new Curso();
      curso2.setTitulo("curso js");
      curso2.setDescricao("descri curso js");
      curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria java");
        mentoria.setDescricao("descri mentoria java");
        mentoria.setData(LocalDate.now());

        /*System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);*/

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devVictor = new Dev();
        devVictor.setNome("Victor");
        devVictor.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Incritos Victor:" +devVictor.getConteudosInscritos());
        devVictor.progedir();
        devVictor.progedir();
        System.out.println("-");
        System.out.println("Conteúdos Incritos Victor:" +devVictor.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos Victor:" +devVictor.getConteudosConcluidos());
        System.out.println("XP:" + devVictor.calcularTotalXp());

        System.out.println("----------------");

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Incritos Camila:" +devCamila.getConteudosInscritos());
        devCamila.progedir();
        devCamila.progedir();
        devCamila.progedir();
        System.out.println("-");
        System.out.println("Conteúdos Incritos Camila:" +devCamila.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos Camila:" +devCamila.getConteudosConcluidos());
        System.out.println("XP:" + devCamila.calcularTotalXp());
    }
}