/*
Implemente o método depositar na classe Conta. Recebe um valor como parâmetro e adiciona no saldo
Implemente o método getNomeDono(), que retorna o nome do dono da Conta.
Implemente a função transferir. Parâmetros: Conta origem, Conta dest, float valor
 */
package objetos5;

import java.util.Random;
import java.util.Scanner;

class Pessoa{
String nome = "User";
char simnao;
String Cpf = "0";

    public void SimNao(char resposta){
    switch(simnao){
            case 's':
                break;
            case 'n':
                System.out.println("Tenha um bom dia!");
           
            case 'S':
                break;
            case 'N':
                System.out.println("Tenha um bom dia!");
        }
    }

    public void setNome(String c) {
    this.nome = c;
  }
    public String getNome() {
    return nome;
  }
    
    public void exit(int exit){
    }
    
    public String getCPF(){
    return Cpf;
   }
    public void setCPF(String Cpf){
    this.Cpf = Cpf;
    }
}

class Conta{
    private double saldo=0;
    private Pessoa dono;
    private int nro_conta;
    private Conta origem;
    private Conta destino;
    private double transferiu, recebeu=0;
    
    Random rand = new Random();

    Conta(Pessoa novo_dono, int nr_conta){
        //Cadastrando novo dono
    dono = novo_dono;
    nro_conta = nr_conta;
    }
    
    public void Transferir(Conta origem, Conta destino, float valor){
    do{
    if((origem.getSaldo() >= valor)&&(valor>0)){
    transferiu = origem.saldo - valor;
    recebeu = destino.saldo + valor;
    saldo = saldo - valor;
    recebeu = recebeu + valor;
    
        System.out.println("Voce transferiu "+valor+" R$ para a conta selecionada.");
    }
    else{
        System.out.println("Saldo indisponível!"); 
        break;
    }
    }while(origem.saldo < valor);
    }
    
    public void Depositar(double deposito){
        if(deposito>0){
        saldo = saldo+deposito;
        System.out.println("Valor do depósito: "+deposito);
        System.out.println("Novo saldo: "+saldo);
        }
        
        else{
        System.out.println("Deposito: "+deposito);
        System.out.println("Erro! Valor invalido!");
        System.out.println("Saldo Atual: "+saldo);
        }
    }
    
    public void Sacar(double valor){
        System.out.println("Sacando: "+valor);
    if(valor<0){
        System.out.println("Erro! Valor negativo.");
    }
    else{
        if(valor>saldo){
            System.out.println("Saldo Insuficiente para saque!");
        }
        else{
    saldo = saldo-valor;
        System.out.println("Seu novo saldo é: "+saldo+"\n");
            }
        }
    }
    
    public double getSaldo(){
        System.out.println("Saldo: "+saldo+"\n");
        return saldo;
    }
    
    public int CriaConta(int num){
        int v[] = new int[num];
    for(int i = 5; i > 0;i--){
        v[i] = rand.nextInt(+1000000);
    }
    nro_conta = v[2];
    return nro_conta;
    }
}
    
public class Objetos5 {

    public static void main(String[] args) {
        Random rand = new Random();
        
        float deposito, saque, transferencia = 0, recebencia;
        int contabase = 0, nro_conta2 = rand.nextInt(+1000000), 
        nro_conta = rand.nextInt(+1000000), menu,
        nro_novaconta = 6, nova_senha = 0, senha = 0;
        String Cpf = "0";
        char simnao = '0';
        
        Scanner my_scan = new Scanner(System.in);
        Pessoa p1 = new Pessoa();
        Pessoa p2 = new Pessoa();
        Conta a = new Conta(p1,nro_conta);
        Conta b = new Conta(p2,nro_conta2);
        
        //colocar logica q pergunta se ja possui conta
        System.out.println("Bem vindo(a). Já possui conta? S/N");
        simnao = my_scan.next().charAt(0);
        p1.SimNao(simnao);
        
        //Criando nova conta
        contabase = a.CriaConta(nro_novaconta);
        
        if(simnao == 'n' || simnao == 'N'){
        System.out.println("Gostaria de abrir sua conta? S/N");
        simnao = my_scan.next().charAt(0);
        p1.SimNao(simnao);
        
        if(simnao == 'n' || simnao == 'N'){
            System.out.println("Tenha um bom dia!");
                System.exit(0);
        }
        
        System.out.println("Qual é o seu nome? ");
        p1.setNome(my_scan.next());
        p1.getNome();

        //Cadastrar Cpf
        System.out.println("Digite seu CPF(Apenas números): ");
        p1.setCPF(my_scan.next());
            System.out.println("CPF cadastrado.");
            
        //Cadastrando senha
        do{
        System.out.println("\n"+p1.nome+", digite a senha que deseja cadastrar(6 números): ");
        nova_senha = my_scan.nextInt();
        if(nova_senha >=100000){         //Perguntar sobre lógica de contar char
            senha = nova_senha;
            break;
        }
        
        else{
            System.out.println("Senha inválida!");
        }
        
    }while(senha < 100000);
        }
        if(simnao == 's' || simnao == 'S'){
            if(senha ==0){
        System.out.println("Nrº CPF padrão: "+Cpf); 
        System.out.println("Senha padrão: "+senha);
        System.out.println("Nome padrão: "+p1.getNome());
            }
        if(senha == nova_senha){
        //Pedir nome da conta usando cpf
        do{    
            System.out.println("Gostaria de saber o numero da sua conta?");
            simnao = my_scan.next().charAt(0);
            p1.SimNao(simnao);
            System.out.println("Para saber o número da sua conta, digite seu CPF: ");
            Cpf = my_scan.next();
            if(Cpf.equals(p1.getCPF())){
            System.out.println("\nO número da conta pertencente ao CPF "+Cpf+ " é: "+contabase+"\n");
            break;
            }
            else{
                System.out.println("CPF invalido!");
            }
        }while(!Cpf.equals(p1.getCPF()));
            
        //Verificando conta
        do{
        System.out.println("Para acessar outras opções de conta digite seu numero de conta: ");
        nro_conta = my_scan.nextInt();
        if(nro_conta == contabase){
        System.out.println("Nome do dono da conta: "+p1.getNome()+"\n");
        break;
        }
        
        else{
        System.out.println("Conta inválida!");
        }
        }while(nro_conta<100000);
        
        //Verificando senha
        do{
        System.out.println("Digite sua senha: ");
        senha = my_scan.nextInt();
        if(senha == nova_senha){
        break;
        }
        
        else{
        System.out.println("Senha inválida!");
        }
        }while(senha != nova_senha);
        
        do{
        System.out.println("Selecione a operação que deseja realizar.");
        System.out.println("Opções: ");
            System.out.println("1. Verificar saldo");
                System.out.println("2. Deposito");
                    System.out.println("3. Saque");
                        System.out.println("4. Transferir");
                            System.out.println("5. Sair");
            
            menu = my_scan.nextInt();
            switch(menu){
            case 1:
                a.getSaldo();
                    break;
            case 2:
            System.out.println("Digite o valor do deposito: ");
                deposito = my_scan.nextFloat();
                    a.Depositar(deposito);
                        break;
            case 3:
            System.out.println("Digite o valor do saque: ");
                saque = my_scan.nextFloat();
                    a.Sacar(saque);
                        break;
           //Configurar a conta destino
            case 4:
                System.out.println("Digite o valor da transferencia: ");
                transferencia = my_scan.nextFloat();
                System.out.println("Conta 2 padrão: "+nro_conta2);
                    System.out.println("Digite o numero da conta para receber a transferencia");
                    recebencia = my_scan.nextInt();
                    do{
                    if(recebencia == nro_conta2){
                    a.Transferir(a, b, transferencia);
                    }
                    else{
                        System.out.println("Conta inválida!");
                    }
                    }while(recebencia != nro_conta2);

            case 5:
            break;
        }
        }while(menu != 5);
        }
        }
    }
}
