//package com.giorgia.apidynamodb;
//
//import com.giorgia.apidynamodb.model.Pessoas;
//import com.giorgia.apidynamodb.service.PessoasService;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class TesteRunner implements CommandLineRunner {
//    private final PessoasService pessoasService;
//
//    public TesteRunner(PessoasService pessoasService) {
//        this.pessoasService = pessoasService;    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        doSomethingWhenStartup();
//    }
//
//    private void doSomethingWhenStartup() {
//
//        // Cria um novo objeto Pessoa
//        Pessoas pessoa = new Pessoas();
//        pessoa.setId("2"); // Substitua pelos valores adequados
//        pessoa.setNome("Nome Teste");
//        pessoa.setEmail("email@teste.com");
//
//        try {
//            // Salva a pessoa na tabela DynamoDB
//            pessoasService.save(pessoa);
//            System.out.println("Uma nova pessoa foi adicionada ao DynamoDB na inicialização!");
//        }catch (Exception e){
//            System.out.println("O envio ao banco de dados falhou. ");
//            e.getStackTrace();
//        }
//
//    }
//}
