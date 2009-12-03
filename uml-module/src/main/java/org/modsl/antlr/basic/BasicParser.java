// $ANTLR 3.0.1 C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g 2009-11-12 21:16:29

	package org.modsl.antlr.basic;
	import org.modsl.core.agt.model.*;
	import org.modsl.core.agt.visitor.*;
	import org.modsl.core.lang.basic.*;
	import java.util.LinkedList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BasicParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "EDGEOP", "NEWLINE", "WS", "'graph'", "'{'", "'}'", "'('", "','", "')'", "':'", "';'"
    };
    public static final int WS=8;
    public static final int NEWLINE=7;
    public static final int EDGEOP=6;
    public static final int INT=5;
    public static final int ID=4;
    public static final int EOF=-1;

        public BasicParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g"; }

    
    	public Graph graph;
    	protected BasicFactory factory = new BasicFactory();



    // $ANTLR start graph
    // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:24:1: graph : 'graph' ID ( procAttributes )? '{' ( statement )* '}' ;
    public final void graph() throws RecognitionException {
        Token ID1=null;

         graph = factory.createGraph(); 
        try {
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:27:2: ( 'graph' ID ( procAttributes )? '{' ( statement )* '}' )
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:27:4: 'graph' ID ( procAttributes )? '{' ( statement )* '}'
            {
            match(input,9,FOLLOW_9_in_graph63); 
            ID1=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_graph65); 
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:27:15: ( procAttributes )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==12) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:27:15: procAttributes
                    {
                    pushFollow(FOLLOW_procAttributes_in_graph67);
                    procAttributes();
                    _fsp--;


                    }
                    break;

            }

            match(input,10,FOLLOW_10_in_graph70); 
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:27:35: ( statement )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:27:35: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_graph72);
            	    statement();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match(input,11,FOLLOW_11_in_graph75); 
             graph.setName(ID1.getText()); 

            }

             graph.accept(new NodeRefVisitor()); 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end graph


    // $ANTLR start procAttributes
    // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:29:1: procAttributes : '(' procAttr ( ',' procAttr )* ')' ;
    public final void procAttributes() throws RecognitionException {
        try {
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:29:15: ( '(' procAttr ( ',' procAttr )* ')' )
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:29:17: '(' procAttr ( ',' procAttr )* ')'
            {
            match(input,12,FOLLOW_12_in_procAttributes84); 
            pushFollow(FOLLOW_procAttr_in_procAttributes86);
            procAttr();
            _fsp--;

            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:29:30: ( ',' procAttr )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:29:31: ',' procAttr
            	    {
            	    match(input,13,FOLLOW_13_in_procAttributes89); 
            	    pushFollow(FOLLOW_procAttr_in_procAttributes91);
            	    procAttr();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match(input,14,FOLLOW_14_in_procAttributes95); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end procAttributes


    // $ANTLR start procAttr
    // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:31:1: procAttr : key= ID ':' v= INT ;
    public final void procAttr() throws RecognitionException {
        Token key=null;
        Token v=null;

        try {
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:31:9: (key= ID ':' v= INT )
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:31:11: key= ID ':' v= INT
            {
            key=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_procAttr104); 
            match(input,15,FOLLOW_15_in_procAttr106); 
            v=(Token)input.LT(1);
            match(input,INT,FOLLOW_INT_in_procAttr110); 
             graph.addProcAttr(key.getText(), v.getText()); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end procAttr


    // $ANTLR start statement
    // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:33:1: statement : ( nodeStatement | edgeStatement ) ';' ;
    public final void statement() throws RecognitionException {
        try {
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:33:10: ( ( nodeStatement | edgeStatement ) ';' )
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:33:12: ( nodeStatement | edgeStatement ) ';'
            {
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:33:12: ( nodeStatement | edgeStatement )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==ID) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==EDGEOP) ) {
                    alt4=2;
                }
                else if ( (LA4_1==16) ) {
                    alt4=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("33:12: ( nodeStatement | edgeStatement )", 4, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("33:12: ( nodeStatement | edgeStatement )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:33:13: nodeStatement
                    {
                    pushFollow(FOLLOW_nodeStatement_in_statement120);
                    nodeStatement();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:33:29: edgeStatement
                    {
                    pushFollow(FOLLOW_edgeStatement_in_statement124);
                    edgeStatement();
                    _fsp--;


                    }
                    break;

            }

            match(input,16,FOLLOW_16_in_statement127); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end statement


    // $ANTLR start nodeStatement
    // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:35:1: nodeStatement : ID ;
    public final void nodeStatement() throws RecognitionException {
        Token ID2=null;

        try {
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:35:15: ( ID )
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:35:17: ID
            {
            ID2=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_nodeStatement135); 
             Node n = factory.createNode(graph, ID2);  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end nodeStatement


    // $ANTLR start edgeStatement
    // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:37:1: edgeStatement : ids+= ID EDGEOP ids+= ID ( EDGEOP ids+= ID )* ;
    public final void edgeStatement() throws RecognitionException {
        Token ids=null;
        List list_ids=null;

        try {
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:37:14: (ids+= ID EDGEOP ids+= ID ( EDGEOP ids+= ID )* )
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:37:16: ids+= ID EDGEOP ids+= ID ( EDGEOP ids+= ID )*
            {
            ids=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_edgeStatement146); 
            if (list_ids==null) list_ids=new ArrayList();
            list_ids.add(ids);

            match(input,EDGEOP,FOLLOW_EDGEOP_in_edgeStatement148); 
            ids=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_edgeStatement152); 
            if (list_ids==null) list_ids=new ArrayList();
            list_ids.add(ids);

            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:37:39: ( EDGEOP ids+= ID )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==EDGEOP) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:37:40: EDGEOP ids+= ID
            	    {
            	    match(input,EDGEOP,FOLLOW_EDGEOP_in_edgeStatement155); 
            	    ids=(Token)input.LT(1);
            	    match(input,ID,FOLLOW_ID_in_edgeStatement159); 
            	    if (list_ids==null) list_ids=new ArrayList();
            	    list_ids.add(ids);


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             factory.createEdges(graph, list_ids); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end edgeStatement


 

    public static final BitSet FOLLOW_9_in_graph63 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_graph65 = new BitSet(new long[]{0x0000000000001400L});
    public static final BitSet FOLLOW_procAttributes_in_graph67 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_graph70 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_statement_in_graph72 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_11_in_graph75 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_procAttributes84 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_procAttr_in_procAttributes86 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_procAttributes89 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_procAttr_in_procAttributes91 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_14_in_procAttributes95 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_procAttr104 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_procAttr106 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_INT_in_procAttr110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeStatement_in_statement120 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_edgeStatement_in_statement124 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_statement127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_nodeStatement135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_edgeStatement146 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EDGEOP_in_edgeStatement148 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_edgeStatement152 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_EDGEOP_in_edgeStatement155 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_edgeStatement159 = new BitSet(new long[]{0x0000000000000042L});

}