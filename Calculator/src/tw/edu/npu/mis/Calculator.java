/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

/**
 * The model class of the calculator application.
 */
public class Calculator  extends java.util.Observable{
    /**
     * @宣告各種變數
     */
    String Mata = "",j;
    double c ,d;

   
    
    /**
     * The available operators of the calculator.
     */
    public enum Operator {
        CLEAR,       // C
        CLEAR_ENTRY, // CE
        BACKSPACE,   // ⌫
        EQUAL,       // =
        PLUS,        // +
        MINUS,       // -
        TIMES,       // ×
        OVER,        // ⁄
        PLUS_MINUS,  // ±
        RECIPROCAL,  // 1/x
        PERCENT,     // %
        SQRT,        // √
        MEM_CLEAR,   // MC
        MEM_SET,     // MS
        MEM_PLUS,    // M+
        MEM_MINUS,   // M-
        MEM_RECALL,   // MR
        Back           // ←
    }
    
    /**
     * @param digit 每次使用者按下0~9的數字鍵
     */
    public void appendDigit(int digit) {
        // TODO code application logic here
        Mata += String.valueOf(digit);
        getDisplay();
    }
    
     /**
     * 使用者按小數點的按鈕，新增小數點
     */
    public void appendDot(String dot) {
        // TODO code application logic here
         if(Mata.indexOf(".")>0)
        {
            
        }else
        {
           Mata  += dot;
           getDisplay(); 
        } 
        
    }
     /**
     * 所有的邏輯運算
     * @param operator 運算符號
     */
    public void performOperation(Operator operator) {
        // TODO code application logic here
          switch (operator) {
            case PLUS:
               c = Integer.parseInt(Mata);
               Mata = "";
               getDisplay();
               j = "+";
                break;
            case MINUS:
               c = Integer.parseInt(Mata);
               Mata = "";
               getDisplay();
               j = "-";
                break;
            case TIMES:
               c = Integer.parseInt(Mata);
               Mata = "";
               getDisplay();
              j = "*";
                break;
            case OVER:
                c = Integer.parseInt(Mata);
               Mata = "";
               getDisplay();
               j = "/";
             case CLEAR:
               Mata = "";
               getDisplay();
                 break;
             case  PLUS_MINUS:
                
                {
                    if(j == "")
                        {
                 
                        }else    
             {
                 if(Double.parseDouble( Mata)>0)
                  {          
                       Mata = "-"+  Mata;
                       getDisplay();
                  }else{
                        Mata=  String.valueOf(Math.abs(Double.parseDouble( Mata))) ;
                        if( Mata.indexOf(".0")== Mata.length()-2)
                        {
                             Mata =  String.valueOf((int)Math.abs(Double.parseDouble( Mata))) ;
                            getDisplay();
                        }                
                  }   
             }
        }
                case  Back :
              if(operator == Operator.Back)
          {
              if(Mata== "")
              {
                        
              }else
              {
                   if(Mata.length()>0) Mata = Mata.substring(0,Mata.length()-1);
                   getDisplay();   
              }
          }
            case EQUAL:
           
                if(j == "+")
                {
                    d= Integer.parseInt(Mata);
                    Mata = String.valueOf(c+d);
                    System.out.print(Mata);
                    getDisplay();
                    Mata="";
                }
                 if(j == "-")
                {
                    d= Integer.parseInt(Mata);
                    Mata = String.valueOf(c-d);
                    System.out.print(Mata);
                    getDisplay();
                    Mata="";
                }
                  if(j == "*")
                {
                    d= Integer.parseInt(Mata);
                    Mata = String.valueOf(c*d);
                    System.out.print(Mata);
                    getDisplay();
                    Mata="";
                }
                   if(j == "/")
                {
                    d= Integer.parseInt(Mata);
                    Mata = String.valueOf(c/d);
                    System.out.print(Mata);
                    getDisplay();
                    Mata="";
                }
                   
                break;
        }
    }
    
    public String getDisplay() {
        // TODO code application logic here
        setChanged();
       notifyObservers(Mata);
        return null;
        
    }
      public void  aa (String AAAA)
    {
        if(AAAA =="+") performOperation(Operator.PLUS);
        if(AAAA =="-") performOperation(Operator.MINUS);
        if(AAAA =="*") performOperation(Operator.TIMES);
        if(AAAA =="/") performOperation(Operator.OVER);
        if(AAAA =="c") performOperation(Operator.CLEAR);  
        if(AAAA =="=") performOperation(Operator.EQUAL);
         if(AAAA =="+/-") performOperation(Operator. PLUS_MINUS);
          if(AAAA =="←") performOperation(Operator. Back);
    }
         /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 Calculator model = new Calculator();
              NewJFrame view = new NewJFrame(model);
              view.setVisible(true);
              model.addObserver(view);
            }
        });

 
    }
}

        
         
            
    
   


