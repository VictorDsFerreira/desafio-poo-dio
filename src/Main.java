import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;
import br.com.dio.desafio.dominio.Conteudo;

import java.time.LocalDate;


public class Main {
  /*Código para gerar uma barra de progresso em ASCII para visualizar a porcentagem de XP concluída. */
    private static String progressBar(double percent, int width) {
      int filled = (int) Math.round((percent / 100.0) * width);
      StringBuilder sb = new StringBuilder("[");
      for (int i = 0; i < width; i++) {
        sb.append(i < filled ? '=' : ' ');
      }
      sb.append("] ");
      sb.append(String.format("%.1f%%", percent));
      return sb.toString();
    }

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

        double xpTotalBootcamp = bootcamp.getConteudos().stream().mapToDouble(Conteudo::calcularXp).sum();

        Dev devVictor = new Dev();
        devVictor.setNome("Victor");
        devVictor.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Incritos Victor:" +devVictor.getConteudosInscritos());
        devVictor.progedir();
        devVictor.progedir();
        System.out.println("-");
        System.out.println("Conteúdos Incritos Victor:" +devVictor.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos Victor:" +devVictor.getConteudosConcluidos());
        double xpVictor = devVictor.calcularTotalXp();
        System.out.println("XP:" + xpVictor + " / " + xpTotalBootcamp);
        double pctVictor = xpTotalBootcamp == 0 ? 0 : (xpVictor / xpTotalBootcamp) * 100.0;
        System.out.println("Progresso XP Victor: " + progressBar(pctVictor, 30));

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
        double xpCamila = devCamila.calcularTotalXp();
        System.out.println("XP:" + xpCamila + " / " + xpTotalBootcamp);
        double pctCamila = xpTotalBootcamp == 0 ? 0 : (xpCamila / xpTotalBootcamp) * 100.0;
        System.out.println("Progresso XP Camila: " + progressBar(pctCamila, 30));
    }
}