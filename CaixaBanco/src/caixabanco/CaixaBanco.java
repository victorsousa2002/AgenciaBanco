/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package caixabanco;

import java.util.Scanner;

public class CaixaBanco {

    
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        
        int op_usuario=0, senha_titular=0, senha_adm, saldo_usuario=0;
        String nome;
        int a=0;
        int[] senha = new int[a];
        int cont_n2 =20, cont_n10 =20, cont_n20 =20, cont_n50 =20;
        int op_mov=0, deposito=0;
        int op_saqcedula =0, op_saqvezes=1, op_saqtotal=0;
        int usu_titular =1;
        int soma, saldo1=0, saldo2=0, saldo3=0, saldo4=0, saldo5=0;
                
        while(usu_titular == 1 ){
        System.out.println("Escola seu tipo de Usuario de login:");
        System.out.println("1 - Titular ");
        System.out.println("2 - Adm ");
        System.out.println("3 - Cadastro");
        System.out.println("4 - Sair");
        op_usuario = s.nextInt();
        
        switch(op_usuario){
            
            case 1:
                usu_titular=2;
                    System.out.println("Digite sua senha: ");
                    senha_titular = s.nextInt();
                    while(senha_titular !=123456 && senha_titular !=222222 && senha_titular !=333333 && senha_titular !=444444 && senha_titular !=555555){
                        System.out.println("Senha invalida, Digite novamente:");
                        senha_titular = s.nextInt();
                    }
                    
                if (senha_titular == 123456){ 
                   saldo_usuario=Cadastro.usuario1(saldo1);
                   
                }
                if (senha_titular == 222222){ 
                   saldo_usuario=Cadastro.usuario2(saldo2);
                   
                }
                if (senha_titular == 333333){ 
                   saldo_usuario=Cadastro.usuario3(saldo3);
                   
                }
                if (senha_titular == 444444){ 
                   saldo_usuario=Cadastro.usuario4(saldo4);
                
                }
                if (senha_titular == 555555){ 
                   saldo_usuario=Cadastro.usuario5(saldo5);
                   
                }
                    while(usu_titular==2){
                    System.out.println("Escolha o tipo de movimentacao desejada: ");
                    System.out.println(" 1 - Deposito ");
                    System.out.println(" 2 - Saque ");
                    System.out.println(" 3 - Saldo ");
                    op_mov = s.nextInt();
                    
                    if(op_mov == 1){ 
                       
                        System.out.println("Digite a quantia que deseja depositar (valor maximo de deposito 1,200R$): ");
                        deposito = s.nextInt(); 

                       if(deposito <= 1200){System.out.println(" ---- Valor depositado na conta ---- ");
                        saldo_usuario=saldo_usuario+deposito;
                        }
                        
                        while(deposito > 1200){

                        if(deposito > 1200){
                        System.out.println("Valor de deposito indisponivel");
                            System.out.println("");
                            System.out.println("Digite a quantia que deseja depositar (valor maximo de deposito 1,200R$): ");
                            deposito = s.nextInt(); 
                            saldo_usuario=saldo_usuario+deposito;
                        }   
                        }         
                    }
                    if (op_mov == 2){
                        System.out.println("Quantidade em notas disponiveis no caixa para saque:");
                        System.out.println(" --- Saldo disponivel "+saldo_usuario+"R$ ---");
                        System.out.println("Notas de 2 (Dois reais): " +cont_n2);
                        System.out.println("Notas de 10 (Dez reais): " +cont_n10);
                        System.out.println("Notas de 20 (Vinte reais): " +cont_n20);
                        System.out.println("Notas de 50 (Cinquenta reais): " +cont_n50);
                        System.out.println("");
                        
                        while(op_saqcedula !=50 && op_saqcedula !=20 && op_saqcedula !=10 && op_saqcedula !=2){
                            
                        System.out.println("Digite a nota que deseja sacar: ");
                        op_saqcedula = s.nextInt();
                        
                        if(op_saqcedula !=50 && op_saqcedula !=20 && op_saqcedula !=10 && op_saqcedula !=2){
                        System.out.println("Opção de cedula indisponivél");
                            System.out.println("");
                        }        
                        } 
                        System.out.println("Digite a quantidade de cedulas: ");
                        op_saqvezes = s.nextInt();
                        
                        while(op_saqcedula== 50 && op_saqvezes > cont_n50 || op_saqcedula== 20 && op_saqvezes > cont_n20
                        || op_saqcedula== 10 && op_saqvezes > cont_n10 || op_saqcedula== 2 && op_saqvezes > cont_n2){
                       
                            System.out.println("Quantidade de notas indisponivel");
                            System.out.println("");
                            System.out.println("Digite a quantidade de cedulas: ");
                            op_saqvezes = s.nextInt();
                        } 
                        op_saqtotal= op_saqcedula*op_saqvezes;
                        
                        if (op_saqtotal > saldo_usuario){System.out.println(" ---- Saldo Indisponivel ---- ");} else {
                        
                        System.out.println("O saque total feito pelo usario: " +op_saqtotal+ ",00R$");
                        saldo_usuario=saldo_usuario-op_saqtotal;
                        
                        if(op_saqtotal > 1000){System.out.println("Quantidade de saque desejada indisponivel");}
                        
                        if(op_saqcedula == 2 ){ cont_n2 = cont_n2 - op_saqvezes;}
                        if(op_saqcedula == 10 ){ cont_n10 = cont_n10 - op_saqvezes;}
                        if(op_saqcedula == 20 ){ cont_n20 = cont_n20 - op_saqvezes;}
                        if(op_saqcedula == 50 ){ cont_n50 = cont_n50 - op_saqvezes;}
                           
                        op_saqcedula=0;
                        
                        }  
                    }
                     if(op_mov == 3){
                        System.out.println("Saldo da conta : " +saldo_usuario+"R$");
                     }
                     
                     System.out.println("Deseja fechar a conta: (1 para Sim) e (2 para Continuar)");
                      usu_titular = s.nextInt();
                      if(usu_titular == 1){saldo_usuario=saldo_usuario+deposito;}
                    while(usu_titular !=1 && usu_titular!=2){
                        System.out.println("opcao invalida,digite novamente");
                        usu_titular = s.nextInt();
                    }
                    }    
                       break;
              
            case 2:
                System.out.println("Digite a senha ADM");
                senha_adm = s.nextInt();
                if (senha_adm == 654321){
                System.out.println("Bem vindo ADM");
                System.out.println("Notas que precisa adicionar para o proximo dia :");
                System.out.println("Notas de 2(DOIS REAIS) :"+(20-cont_n2));
                System.out.println("Notas de 10(DEZ REAIS) :"+(20-cont_n10));
                System.out.println("Notas de 20(VINTE REAIS) :"+(20-cont_n20));
                System.out.println("Notas de 50(CINQUENTA REAIS) :"+(20-cont_n50));
                }else {System.out.println("Senha incorreta - Tente novamente");}
                
                System.out.println("Deseja fechar a conta: (1 para Sim) e (2 para encerrar o sistema)");
                usu_titular = s.nextInt();
                if(usu_titular==2){
                    System.exit(0);
                }
                while(usu_titular !=1 && usu_titular!=2){
                        System.out.println("opcao invalida,digite novamente");
                        usu_titular = s.nextInt();
                    }
                break;
                
            case 3:
                System.out.println("Digite seu Nome:");
                nome = s.next();
                System.out.println("Digite sua senha:");
                senha[a] = s.nextInt();
                  
                int[] senha_usuarios = {senha[a]};
                
                for(int i=0; i<10; i++) {
                   senha[a]=+a;
                   System.out.println("A senha é:" +senha_usuarios[i]);
                }

                System.out.println("Deseja fechar a conta: (1 para Sim) e (2 para encerrar o sistema)");
                usu_titular = s.nextInt();
                if(usu_titular==2){
                    System.exit(0);
                }
                while(usu_titular !=1 && usu_titular!=2){
                        System.out.println("opcao invalida,digite novamente");
                        usu_titular = s.nextInt();
                    }
                break;
                
           case 4:
                System.out.println("Sair do programa");
                System.exit(0);
                break;
                }    
                           
        
        soma=deposito-op_saqtotal;
        
        if (senha_titular==123456){
            saldo1+=soma;         
        }
        if (senha_titular==222222){
            saldo2+=soma; 
        }
        if (senha_titular==333333){
            saldo3+=soma; 
        }
        if (senha_titular==444444){
            saldo4+=soma;           
        }
        if (senha_titular==555555){
            saldo5+=soma;
        }
        
        soma=0;   
        op_saqtotal=0;
     
                }          
          }
    }