// $ANTLR 3.0.1 C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g 2009-11-12 21:16:30

package org.modsl.antlr.uml;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.modsl.core.agt.model.Graph;
import org.modsl.core.agt.model.NodeLabel;
import org.modsl.core.agt.visitor.NodeRefVisitor;
import org.modsl.core.lang.uml.UMLMetaType;
import org.modsl.core.lang.uml.factory.UMLClassFactory;
import org.modsl.core.lang.uml.factory.UMLCollabFactory;
import org.modsl.core.lang.uml.factory.UMLSeqFactory;

public class UMLParser extends Parser {
	public static final String[] tokenNames = new String[] { "<invalid>",
			"<EOR>", "<DOWN>", "<UP>", "ID", "EDGEOP", "INT", "STRING",
			"ML_COMMENT", "NEWLINE", "SL_COMMENT", "WS", "'collab'",
			"'collaboration'", "'communication'", "'diagram'", "'{'", "'}'",
			"';'", "'.'", "'sequence'", "'seq'", "'class'", "'abstract'",
			"'<'", "','", "'>'", "'extends'", "'implements'", "'interface'",
			"'static'", "'('", "')'", "':'", "'-'", "'+'", "'#'", "'..'", "'*'" };
	public static final int ML_COMMENT = 8;
	public static final int WS = 11;
	public static final int NEWLINE = 9;
	public static final int EDGEOP = 5;
	public static final int SL_COMMENT = 10;
	public static final int INT = 6;
	public static final int ID = 4;
	public static final int EOF = -1;
	public static final int STRING = 7;

	public UMLParser(TokenStream input) {
		super(input);
	}

	public String[] getTokenNames() {
		return tokenNames;
	}

	public String getGrammarFileName() {
		return "C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g";
	}

	public Graph graph;
	protected LinkedList<Graph> nodes = new LinkedList<Graph>();
	protected UMLCollabFactory collabFactory = new UMLCollabFactory();
	protected UMLClassFactory classFactory = new UMLClassFactory();
	protected UMLSeqFactory seqFactory = new UMLSeqFactory();
	protected List<NodeLabel> curElements = new LinkedList<NodeLabel>();
	protected LinkedList<String> collabEdges = new LinkedList<String>();
	protected LinkedList<String> seqEdges = new LinkedList<String>();
	protected LinkedList<String> curAggs = new LinkedList<String>();

	// $ANTLR start diagram
	// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:32:1:
	// diagram : ( classDiagram | collabDiagram | seqDiagram );
	public final void diagram() throws RecognitionException {
		try {
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:32:9:
			// ( classDiagram | collabDiagram | seqDiagram )
			int alt1 = 3;
			switch (input.LA(1)) {
			case 22: {
				alt1 = 1;
			}
				break;
			case 12:
			case 13:
			case 14: {
				alt1 = 2;
			}
				break;
			case 20:
			case 21: {
				alt1 = 3;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException(
						"32:1: diagram : ( classDiagram | collabDiagram | seqDiagram );",
						1, 0, input);

				throw nvae;
			}

			switch (alt1) {
			case 1:
				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:32:11:
				// classDiagram
			{
				pushFollow(FOLLOW_classDiagram_in_diagram50);
				classDiagram();
				_fsp--;

			}
				break;
			case 2:
				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:32:26:
				// collabDiagram
			{
				pushFollow(FOLLOW_collabDiagram_in_diagram54);
				collabDiagram();
				_fsp--;

			}
				break;
			case 3:
				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:32:42:
				// seqDiagram
			{
				pushFollow(FOLLOW_seqDiagram_in_diagram58);
				seqDiagram();
				_fsp--;

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}

	// $ANTLR end diagram

	// $ANTLR start collabDiagram
	// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:34:1:
	// collabDiagram : ( 'collab' | 'collaboration' | 'communication' ) (
	// 'diagram' )? ID ( procAttributes )? '{' ( collabStmt )* '}' ;
	public final void collabDiagram() throws RecognitionException {
		Token ID1 = null;

		graph = collabFactory.createGraph();
		try {
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:37:2:
			// ( ( 'collab' | 'collaboration' | 'communication' ) ( 'diagram' )?
			// ID ( procAttributes )? '{' ( collabStmt )* '}' )
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:37:4:
			// ( 'collab' | 'collaboration' | 'communication' ) ( 'diagram' )?
			// ID ( procAttributes )? '{' ( collabStmt )* '}'
			{
				if ((input.LA(1) >= 12 && input.LA(1) <= 14)) {
					input.consume();
					errorRecovery = false;
				} else {
					MismatchedSetException mse = new MismatchedSetException(
							null, input);
					recoverFromMismatchedSet(input, mse,
							FOLLOW_set_in_collabDiagram80);
					throw mse;
				}

				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:37:51:
				// ( 'diagram' )?
				int alt2 = 2;
				int LA2_0 = input.LA(1);

				if ((LA2_0 == 15)) {
					alt2 = 1;
				}
				switch (alt2) {
				case 1:
					// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:37:51:
					// 'diagram'
				{
					match(input, 15, FOLLOW_15_in_collabDiagram92);

				}
					break;

				}

				ID1 = (Token) input.LT(1);
				match(input, ID, FOLLOW_ID_in_collabDiagram95);
				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:37:65:
				// ( procAttributes )?
				int alt3 = 2;
				int LA3_0 = input.LA(1);

				if ((LA3_0 == 31)) {
					alt3 = 1;
				}
				switch (alt3) {
				case 1:
					// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:37:65:
					// procAttributes
				{
					pushFollow(FOLLOW_procAttributes_in_collabDiagram97);
					procAttributes();
					_fsp--;

				}
					break;

				}

				match(input, 16, FOLLOW_16_in_collabDiagram100);
				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:37:85:
				// ( collabStmt )*
				loop4: do {
					int alt4 = 2;
					int LA4_0 = input.LA(1);

					if ((LA4_0 == ID || LA4_0 == 33)) {
						alt4 = 1;
					}

					switch (alt4) {
					case 1:
						// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:37:85:
						// collabStmt
					{
						pushFollow(FOLLOW_collabStmt_in_collabDiagram102);
						collabStmt();
						_fsp--;

					}
						break;

					default:
						break loop4;
					}
				} while (true);

				match(input, 17, FOLLOW_17_in_collabDiagram105);
				graph.setName(ID1.getText());

			}

			graph.accept(new NodeRefVisitor());
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}

	// $ANTLR end collabDiagram

	// $ANTLR start collabStmt
	// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:39:1:
	// collabStmt : objInstance ( collab2Stmt )+ ';' ;
	public final void collabStmt() throws RecognitionException {
		objInstance_return objInstance2 = null;

		try {
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:39:11:
			// ( objInstance ( collab2Stmt )+ ';' )
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:39:13:
			// objInstance ( collab2Stmt )+ ';'
			{
				pushFollow(FOLLOW_objInstance_in_collabStmt114);
				objInstance2 = objInstance();
				_fsp--;

				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:39:25:
				// ( collab2Stmt )+
				int cnt5 = 0;
				loop5: do {
					int alt5 = 2;
					int LA5_0 = input.LA(1);

					if ((LA5_0 == EDGEOP)) {
						alt5 = 1;
					}

					switch (alt5) {
					case 1:
						// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:39:25:
						// collab2Stmt
					{
						pushFollow(FOLLOW_collab2Stmt_in_collabStmt116);
						collab2Stmt();
						_fsp--;

					}
						break;

					default:
						if (cnt5 >= 1)
							break loop5;
						EarlyExitException eee = new EarlyExitException(5,
								input);
						throw eee;
					}
					cnt5++;
				} while (true);

				match(input, 18, FOLLOW_18_in_collabStmt119);
				collabEdges.addFirst(input.toString(objInstance2.start,
						objInstance2.stop));
				collabFactory.createEdges(graph, collabEdges);
				collabEdges.clear();

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}

	// $ANTLR end collabStmt

	// $ANTLR start collab2Stmt
	// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:42:1:
	// collab2Stmt : EDGEOP objInstance '.' method ;
	public final void collab2Stmt() throws RecognitionException {
		method_return method3 = null;

		objInstance_return objInstance4 = null;

		try {
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:42:12:
			// ( EDGEOP objInstance '.' method )
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:42:14:
			// EDGEOP objInstance '.' method
			{
				match(input, EDGEOP, FOLLOW_EDGEOP_in_collab2Stmt131);
				pushFollow(FOLLOW_objInstance_in_collab2Stmt133);
				objInstance4 = objInstance();
				_fsp--;

				match(input, 19, FOLLOW_19_in_collab2Stmt135);
				pushFollow(FOLLOW_method_in_collab2Stmt137);
				method3 = method();
				_fsp--;

				collabEdges.add(input.toString(method3.start, method3.stop));
				collabEdges.add(input.toString(objInstance4.start,
						objInstance4.stop));

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}

	// $ANTLR end collab2Stmt

	// $ANTLR start seqDiagram
	// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:45:1:
	// seqDiagram : ( 'sequence' | 'seq' ) ( 'diagram' )? ID ( procAttributes )?
	// '{' ( seqStmt )* '}' ;
	public final void seqDiagram() throws RecognitionException {
		Token ID5 = null;

		graph = seqFactory.createGraph();
		try {
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:48:5:
			// ( ( 'sequence' | 'seq' ) ( 'diagram' )? ID ( procAttributes )?
			// '{' ( seqStmt )* '}' )
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:48:7:
			// ( 'sequence' | 'seq' ) ( 'diagram' )? ID ( procAttributes )? '{'
			// ( seqStmt )* '}'
			{
				if ((input.LA(1) >= 20 && input.LA(1) <= 21)) {
					input.consume();
					errorRecovery = false;
				} else {
					MismatchedSetException mse = new MismatchedSetException(
							null, input);
					recoverFromMismatchedSet(input, mse,
							FOLLOW_set_in_seqDiagram170);
					throw mse;
				}

				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:48:28:
				// ( 'diagram' )?
				int alt6 = 2;
				int LA6_0 = input.LA(1);

				if ((LA6_0 == 15)) {
					alt6 = 1;
				}
				switch (alt6) {
				case 1:
					// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:48:28:
					// 'diagram'
				{
					match(input, 15, FOLLOW_15_in_seqDiagram178);

				}
					break;

				}

				ID5 = (Token) input.LT(1);
				match(input, ID, FOLLOW_ID_in_seqDiagram181);
				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:48:42:
				// ( procAttributes )?
				int alt7 = 2;
				int LA7_0 = input.LA(1);

				if ((LA7_0 == 31)) {
					alt7 = 1;
				}
				switch (alt7) {
				case 1:
					// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:48:42:
					// procAttributes
				{
					pushFollow(FOLLOW_procAttributes_in_seqDiagram183);
					procAttributes();
					_fsp--;

				}
					break;

				}

				match(input, 16, FOLLOW_16_in_seqDiagram186);
				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:48:62:
				// ( seqStmt )*
				loop8: do {
					int alt8 = 2;
					int LA8_0 = input.LA(1);

					if ((LA8_0 == ID || LA8_0 == 33)) {
						alt8 = 1;
					}

					switch (alt8) {
					case 1:
						// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:48:62:
						// seqStmt
					{
						pushFollow(FOLLOW_seqStmt_in_seqDiagram188);
						seqStmt();
						_fsp--;

					}
						break;

					default:
						break loop8;
					}
				} while (true);

				match(input, 17, FOLLOW_17_in_seqDiagram191);
				graph.setName(ID5.getText());

			}

			graph.accept(new NodeRefVisitor());
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}

	// $ANTLR end seqDiagram

	// $ANTLR start seqStmt
	// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:50:1:
	// seqStmt : objInstance ( seq2Stmt )+ ';' ;
	public final void seqStmt() throws RecognitionException {
		objInstance_return objInstance6 = null;

		try {
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:50:8:
			// ( objInstance ( seq2Stmt )+ ';' )
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:50:10:
			// objInstance ( seq2Stmt )+ ';'
			{
				pushFollow(FOLLOW_objInstance_in_seqStmt200);
				objInstance6 = objInstance();
				_fsp--;

				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:50:22:
				// ( seq2Stmt )+
				int cnt9 = 0;
				loop9: do {
					int alt9 = 2;
					int LA9_0 = input.LA(1);

					if ((LA9_0 == EDGEOP)) {
						alt9 = 1;
					}

					switch (alt9) {
					case 1:
						// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:50:22:
						// seq2Stmt
					{
						pushFollow(FOLLOW_seq2Stmt_in_seqStmt202);
						seq2Stmt();
						_fsp--;

					}
						break;

					default:
						if (cnt9 >= 1)
							break loop9;
						EarlyExitException eee = new EarlyExitException(9,
								input);
						throw eee;
					}
					cnt9++;
				} while (true);

				match(input, 18, FOLLOW_18_in_seqStmt205);
				seqEdges.addFirst(input.toString(objInstance6.start,
						objInstance6.stop));
				seqFactory.createEdges(graph, seqEdges);
				seqEdges.clear();

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}

	// $ANTLR end seqStmt

	// $ANTLR start seq2Stmt
	// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:53:1:
	// seq2Stmt : EDGEOP objInstance '.' method ;
	public final void seq2Stmt() throws RecognitionException {
		method_return method7 = null;

		objInstance_return objInstance8 = null;

		try {
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:53:9:
			// ( EDGEOP objInstance '.' method )
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:53:11:
			// EDGEOP objInstance '.' method
			{
				match(input, EDGEOP, FOLLOW_EDGEOP_in_seq2Stmt217);
				pushFollow(FOLLOW_objInstance_in_seq2Stmt219);
				objInstance8 = objInstance();
				_fsp--;

				match(input, 19, FOLLOW_19_in_seq2Stmt221);
				pushFollow(FOLLOW_method_in_seq2Stmt223);
				method7 = method();
				_fsp--;

				seqEdges.add(input.toString(method7.start, method7.stop));
				seqEdges.add(input.toString(objInstance8.start,
						objInstance8.stop));

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}

	// $ANTLR end seq2Stmt

	// $ANTLR start classDiagram
	// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:56:1:
	// classDiagram : 'class' ( 'diagram' )? ID ( procAttributes )? '{' (
	// classStmt | interfaceStmt )* '}' ;
	public final void classDiagram() throws RecognitionException {
		Token ID9 = null;

		graph = classFactory.createGraph();
		try {
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:59:2:
			// ( 'class' ( 'diagram' )? ID ( procAttributes )? '{' ( classStmt |
			// interfaceStmt )* '}' )
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:59:4:
			// 'class' ( 'diagram' )? ID ( procAttributes )? '{' ( classStmt |
			// interfaceStmt )* '}'
			{
				match(input, 22, FOLLOW_22_in_classDiagram248);
				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:59:12:
				// ( 'diagram' )?
				int alt10 = 2;
				int LA10_0 = input.LA(1);

				if ((LA10_0 == 15)) {
					alt10 = 1;
				}
				switch (alt10) {
				case 1:
					// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:59:12:
					// 'diagram'
				{
					match(input, 15, FOLLOW_15_in_classDiagram250);

				}
					break;

				}

				ID9 = (Token) input.LT(1);
				match(input, ID, FOLLOW_ID_in_classDiagram253);
				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:59:26:
				// ( procAttributes )?
				int alt11 = 2;
				int LA11_0 = input.LA(1);

				if ((LA11_0 == 31)) {
					alt11 = 1;
				}
				switch (alt11) {
				case 1:
					// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:59:26:
					// procAttributes
				{
					pushFollow(FOLLOW_procAttributes_in_classDiagram255);
					procAttributes();
					_fsp--;

				}
					break;

				}

				match(input, 16, FOLLOW_16_in_classDiagram258);
				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:59:46:
				// ( classStmt | interfaceStmt )*
				loop12: do {
					int alt12 = 3;
					int LA12_0 = input.LA(1);

					if (((LA12_0 >= 22 && LA12_0 <= 23))) {
						alt12 = 1;
					} else if ((LA12_0 == 29)) {
						alt12 = 2;
					}

					switch (alt12) {
					case 1:
						// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:59:47:
						// classStmt
					{
						pushFollow(FOLLOW_classStmt_in_classDiagram261);
						classStmt();
						_fsp--;

					}
						break;
					case 2:
						// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:59:59:
						// interfaceStmt
					{
						pushFollow(FOLLOW_interfaceStmt_in_classDiagram265);
						interfaceStmt();
						_fsp--;

					}
						break;

					default:
						break loop12;
					}
				} while (true);

				match(input, 17, FOLLOW_17_in_classDiagram269);
				graph.setName(ID9.getText());

			}

			graph.accept(new NodeRefVisitor());
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}

	// $ANTLR end classDiagram

	// $ANTLR start classStmt
	// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:61:1:
	// classStmt : (abs= 'abstract' )? 'class' id= ID ( '<' gid+= ID ( ',' gid+=
	// ID )* '>' )? ( 'extends' eid+= ID ( ',' eid+= ID )* )? ( 'implements'
	// iid+= ID ( ',' iid+= ID )* )? '{' ( classElementStmt )* '}' ;
	public final void classStmt() throws RecognitionException {
		Token abs = null;
		Token id = null;
		Token gid = null;
		Token eid = null;
		Token iid = null;
		List list_gid = null;
		List list_eid = null;
		List list_iid = null;

		try {
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:61:10:
			// ( (abs= 'abstract' )? 'class' id= ID ( '<' gid+= ID ( ',' gid+=
			// ID )* '>' )? ( 'extends' eid+= ID ( ',' eid+= ID )* )? (
			// 'implements' iid+= ID ( ',' iid+= ID )* )? '{' ( classElementStmt
			// )* '}' )
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:61:12:
			// (abs= 'abstract' )? 'class' id= ID ( '<' gid+= ID ( ',' gid+= ID
			// )* '>' )? ( 'extends' eid+= ID ( ',' eid+= ID )* )? (
			// 'implements' iid+= ID ( ',' iid+= ID )* )? '{' ( classElementStmt
			// )* '}'
			{
				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:61:12:
				// (abs= 'abstract' )?
				int alt13 = 2;
				int LA13_0 = input.LA(1);

				if ((LA13_0 == 23)) {
					alt13 = 1;
				}
				switch (alt13) {
				case 1:
					// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:61:13:
					// abs= 'abstract'
				{
					abs = (Token) input.LT(1);
					match(input, 23, FOLLOW_23_in_classStmt281);

				}
					break;

				}

				match(input, 22, FOLLOW_22_in_classStmt285);
				id = (Token) input.LT(1);
				match(input, ID, FOLLOW_ID_in_classStmt289);
				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:61:44:
				// ( '<' gid+= ID ( ',' gid+= ID )* '>' )?
				int alt15 = 2;
				int LA15_0 = input.LA(1);

				if ((LA15_0 == 24)) {
					alt15 = 1;
				}
				switch (alt15) {
				case 1:
					// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:61:45:
					// '<' gid+= ID ( ',' gid+= ID )* '>'
				{
					match(input, 24, FOLLOW_24_in_classStmt292);
					gid = (Token) input.LT(1);
					match(input, ID, FOLLOW_ID_in_classStmt296);
					if (list_gid == null)
						list_gid = new ArrayList();
					list_gid.add(gid);

					// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:61:57:
					// ( ',' gid+= ID )*
					loop14: do {
						int alt14 = 2;
						int LA14_0 = input.LA(1);

						if ((LA14_0 == 25)) {
							alt14 = 1;
						}

						switch (alt14) {
						case 1:
							// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:61:58:
							// ',' gid+= ID
						{
							match(input, 25, FOLLOW_25_in_classStmt299);
							gid = (Token) input.LT(1);
							match(input, ID, FOLLOW_ID_in_classStmt303);
							if (list_gid == null)
								list_gid = new ArrayList();
							list_gid.add(gid);

						}
							break;

						default:
							break loop14;
						}
					} while (true);

					match(input, 26, FOLLOW_26_in_classStmt307);

				}
					break;

				}

				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:62:2:
				// ( 'extends' eid+= ID ( ',' eid+= ID )* )?
				int alt17 = 2;
				int LA17_0 = input.LA(1);

				if ((LA17_0 == 27)) {
					alt17 = 1;
				}
				switch (alt17) {
				case 1:
					// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:62:3:
					// 'extends' eid+= ID ( ',' eid+= ID )*
				{
					match(input, 27, FOLLOW_27_in_classStmt313);
					eid = (Token) input.LT(1);
					match(input, ID, FOLLOW_ID_in_classStmt317);
					if (list_eid == null)
						list_eid = new ArrayList();
					list_eid.add(eid);

					// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:62:21:
					// ( ',' eid+= ID )*
					loop16: do {
						int alt16 = 2;
						int LA16_0 = input.LA(1);

						if ((LA16_0 == 25)) {
							alt16 = 1;
						}

						switch (alt16) {
						case 1:
							// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:62:22:
							// ',' eid+= ID
						{
							match(input, 25, FOLLOW_25_in_classStmt320);
							eid = (Token) input.LT(1);
							match(input, ID, FOLLOW_ID_in_classStmt324);
							if (list_eid == null)
								list_eid = new ArrayList();
							list_eid.add(eid);

						}
							break;

						default:
							break loop16;
						}
					} while (true);

				}
					break;

				}

				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:62:38:
				// ( 'implements' iid+= ID ( ',' iid+= ID )* )?
				int alt19 = 2;
				int LA19_0 = input.LA(1);

				if ((LA19_0 == 28)) {
					alt19 = 1;
				}
				switch (alt19) {
				case 1:
					// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:62:39:
					// 'implements' iid+= ID ( ',' iid+= ID )*
				{
					match(input, 28, FOLLOW_28_in_classStmt331);
					iid = (Token) input.LT(1);
					match(input, ID, FOLLOW_ID_in_classStmt335);
					if (list_iid == null)
						list_iid = new ArrayList();
					list_iid.add(iid);

					// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:62:60:
					// ( ',' iid+= ID )*
					loop18: do {
						int alt18 = 2;
						int LA18_0 = input.LA(1);

						if ((LA18_0 == 25)) {
							alt18 = 1;
						}

						switch (alt18) {
						case 1:
							// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:62:61:
							// ',' iid+= ID
						{
							match(input, 25, FOLLOW_25_in_classStmt338);
							iid = (Token) input.LT(1);
							match(input, ID, FOLLOW_ID_in_classStmt342);
							if (list_iid == null)
								list_iid = new ArrayList();
							list_iid.add(iid);

						}
							break;

						default:
							break loop18;
						}
					} while (true);

				}
					break;

				}

				match(input, 16, FOLLOW_16_in_classStmt350);
				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:63:6:
				// ( classElementStmt )*
				loop20: do {
					int alt20 = 2;
					int LA20_0 = input.LA(1);

					if ((LA20_0 == ID || LA20_0 == INT || LA20_0 == 23
							|| LA20_0 == 30 || (LA20_0 >= 34 && LA20_0 <= 36) || LA20_0 == 38)) {
						alt20 = 1;
					}

					switch (alt20) {
					case 1:
						// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:63:6:
						// classElementStmt
					{
						pushFollow(FOLLOW_classElementStmt_in_classStmt352);
						classElementStmt();
						_fsp--;

					}
						break;

					default:
						break loop20;
					}
				} while (true);

				match(input, 17, FOLLOW_17_in_classStmt355);

				classFactory.createClassNode(abs, graph, id, list_gid,
						curElements, list_eid, list_iid, curAggs);
				curElements.clear();
				curAggs.clear();

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}

	// $ANTLR end classStmt

	// $ANTLR start interfaceStmt
	// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:70:1:
	// interfaceStmt : 'interface' id= ID ( '<' gid+= ID ( ',' gid+= ID )* '>'
	// )? ( 'extends' eid+= ID ( ',' eid+= ID )* )? '{' ( interfaceElementStmt
	// )* '}' ;
	public final void interfaceStmt() throws RecognitionException {
		Token id = null;
		Token gid = null;
		Token eid = null;
		List list_gid = null;
		List list_eid = null;

		try {
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:70:14:
			// ( 'interface' id= ID ( '<' gid+= ID ( ',' gid+= ID )* '>' )? (
			// 'extends' eid+= ID ( ',' eid+= ID )* )? '{' (
			// interfaceElementStmt )* '}' )
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:70:16:
			// 'interface' id= ID ( '<' gid+= ID ( ',' gid+= ID )* '>' )? (
			// 'extends' eid+= ID ( ',' eid+= ID )* )? '{' (
			// interfaceElementStmt )* '}'
			{
				match(input, 29, FOLLOW_29_in_interfaceStmt366);
				id = (Token) input.LT(1);
				match(input, ID, FOLLOW_ID_in_interfaceStmt370);
				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:70:34:
				// ( '<' gid+= ID ( ',' gid+= ID )* '>' )?
				int alt22 = 2;
				int LA22_0 = input.LA(1);

				if ((LA22_0 == 24)) {
					alt22 = 1;
				}
				switch (alt22) {
				case 1:
					// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:70:35:
					// '<' gid+= ID ( ',' gid+= ID )* '>'
				{
					match(input, 24, FOLLOW_24_in_interfaceStmt373);
					gid = (Token) input.LT(1);
					match(input, ID, FOLLOW_ID_in_interfaceStmt377);
					if (list_gid == null)
						list_gid = new ArrayList();
					list_gid.add(gid);

					// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:70:47:
					// ( ',' gid+= ID )*
					loop21: do {
						int alt21 = 2;
						int LA21_0 = input.LA(1);

						if ((LA21_0 == 25)) {
							alt21 = 1;
						}

						switch (alt21) {
						case 1:
							// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:70:48:
							// ',' gid+= ID
						{
							match(input, 25, FOLLOW_25_in_interfaceStmt380);
							gid = (Token) input.LT(1);
							match(input, ID, FOLLOW_ID_in_interfaceStmt384);
							if (list_gid == null)
								list_gid = new ArrayList();
							list_gid.add(gid);

						}
							break;

						default:
							break loop21;
						}
					} while (true);

					match(input, 26, FOLLOW_26_in_interfaceStmt388);

				}
					break;

				}

				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:71:2:
				// ( 'extends' eid+= ID ( ',' eid+= ID )* )?
				int alt24 = 2;
				int LA24_0 = input.LA(1);

				if ((LA24_0 == 27)) {
					alt24 = 1;
				}
				switch (alt24) {
				case 1:
					// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:71:3:
					// 'extends' eid+= ID ( ',' eid+= ID )*
				{
					match(input, 27, FOLLOW_27_in_interfaceStmt395);
					eid = (Token) input.LT(1);
					match(input, ID, FOLLOW_ID_in_interfaceStmt399);
					if (list_eid == null)
						list_eid = new ArrayList();
					list_eid.add(eid);

					// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:71:21:
					// ( ',' eid+= ID )*
					loop23: do {
						int alt23 = 2;
						int LA23_0 = input.LA(1);

						if ((LA23_0 == 25)) {
							alt23 = 1;
						}

						switch (alt23) {
						case 1:
							// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:71:22:
							// ',' eid+= ID
						{
							match(input, 25, FOLLOW_25_in_interfaceStmt402);
							eid = (Token) input.LT(1);
							match(input, ID, FOLLOW_ID_in_interfaceStmt406);
							if (list_eid == null)
								list_eid = new ArrayList();
							list_eid.add(eid);

						}
							break;

						default:
							break loop23;
						}
					} while (true);

				}
					break;

				}

				match(input, 16, FOLLOW_16_in_interfaceStmt412);
				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:71:42:
				// ( interfaceElementStmt )*
				loop25: do {
					int alt25 = 2;
					int LA25_0 = input.LA(1);

					if ((LA25_0 == ID || LA25_0 == 30 || (LA25_0 >= 34 && LA25_0 <= 36))) {
						alt25 = 1;
					}

					switch (alt25) {
					case 1:
						// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:71:42:
						// interfaceElementStmt
					{
						pushFollow(FOLLOW_interfaceElementStmt_in_interfaceStmt414);
						interfaceElementStmt();
						_fsp--;

					}
						break;

					default:
						break loop25;
					}
				} while (true);

				match(input, 17, FOLLOW_17_in_interfaceStmt417);
				classFactory.createInterfaceNode(graph, id, list_gid,
						curElements, list_eid);
				curElements.clear();

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}

	// $ANTLR end interfaceStmt

	// $ANTLR start classElementStmt
	// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:74:1:
	// classElementStmt : ( varClassElementStmt | staticVarClassElementStmt |
	// methodClassElementStmt | abstractMethodClassElementStmt |
	// staticMethodClassElementStmt | aggStmt );
	public final void classElementStmt() throws RecognitionException {
		try {
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:74:17:
			// ( varClassElementStmt | staticVarClassElementStmt |
			// methodClassElementStmt | abstractMethodClassElementStmt |
			// staticMethodClassElementStmt | aggStmt )
			int alt26 = 6;
			switch (input.LA(1)) {
			case 34:
			case 35:
			case 36: {
				int LA26_1 = input.LA(2);

				if ((LA26_1 == ID)) {
					int LA26_6 = input.LA(3);

					if ((LA26_6 == 31)) {
						alt26 = 3;
					} else if ((LA26_6 == 18 || LA26_6 == 33)) {
						alt26 = 1;
					} else {
						NoViableAltException nvae = new NoViableAltException(
								"74:1: classElementStmt : ( varClassElementStmt | staticVarClassElementStmt | methodClassElementStmt | abstractMethodClassElementStmt | staticMethodClassElementStmt | aggStmt );",
								26, 6, input);

						throw nvae;
					}
				} else {
					NoViableAltException nvae = new NoViableAltException(
							"74:1: classElementStmt : ( varClassElementStmt | staticVarClassElementStmt | methodClassElementStmt | abstractMethodClassElementStmt | staticMethodClassElementStmt | aggStmt );",
							26, 1, input);

					throw nvae;
				}
			}
				break;
			case ID: {
				switch (input.LA(2)) {
				case 31: {
					alt26 = 3;
				}
					break;
				case 18:
				case 33: {
					alt26 = 1;
				}
					break;
				case EDGEOP:
				case 37: {
					alt26 = 6;
				}
					break;
				default:
					NoViableAltException nvae = new NoViableAltException(
							"74:1: classElementStmt : ( varClassElementStmt | staticVarClassElementStmt | methodClassElementStmt | abstractMethodClassElementStmt | staticMethodClassElementStmt | aggStmt );",
							26, 2, input);

					throw nvae;
				}

			}
				break;
			case 30: {
				int LA26_3 = input.LA(2);

				if (((LA26_3 >= 34 && LA26_3 <= 36))) {
					int LA26_9 = input.LA(3);

					if ((LA26_9 == ID)) {
						int LA26_10 = input.LA(4);

						if ((LA26_10 == 31)) {
							alt26 = 5;
						} else if ((LA26_10 == 18 || LA26_10 == 33)) {
							alt26 = 2;
						} else {
							NoViableAltException nvae = new NoViableAltException(
									"74:1: classElementStmt : ( varClassElementStmt | staticVarClassElementStmt | methodClassElementStmt | abstractMethodClassElementStmt | staticMethodClassElementStmt | aggStmt );",
									26, 10, input);

							throw nvae;
						}
					} else {
						NoViableAltException nvae = new NoViableAltException(
								"74:1: classElementStmt : ( varClassElementStmt | staticVarClassElementStmt | methodClassElementStmt | abstractMethodClassElementStmt | staticMethodClassElementStmt | aggStmt );",
								26, 9, input);

						throw nvae;
					}
				} else if ((LA26_3 == ID)) {
					int LA26_10 = input.LA(3);

					if ((LA26_10 == 31)) {
						alt26 = 5;
					} else if ((LA26_10 == 18 || LA26_10 == 33)) {
						alt26 = 2;
					} else {
						NoViableAltException nvae = new NoViableAltException(
								"74:1: classElementStmt : ( varClassElementStmt | staticVarClassElementStmt | methodClassElementStmt | abstractMethodClassElementStmt | staticMethodClassElementStmt | aggStmt );",
								26, 10, input);

						throw nvae;
					}
				} else {
					NoViableAltException nvae = new NoViableAltException(
							"74:1: classElementStmt : ( varClassElementStmt | staticVarClassElementStmt | methodClassElementStmt | abstractMethodClassElementStmt | staticMethodClassElementStmt | aggStmt );",
							26, 3, input);

					throw nvae;
				}
			}
				break;
			case 23: {
				alt26 = 4;
			}
				break;
			case INT:
			case 38: {
				alt26 = 6;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException(
						"74:1: classElementStmt : ( varClassElementStmt | staticVarClassElementStmt | methodClassElementStmt | abstractMethodClassElementStmt | staticMethodClassElementStmt | aggStmt );",
						26, 0, input);

				throw nvae;
			}

			switch (alt26) {
			case 1:
				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:74:19:
				// varClassElementStmt
			{
				pushFollow(FOLLOW_varClassElementStmt_in_classElementStmt430);
				varClassElementStmt();
				_fsp--;

			}
				break;
			case 2:
				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:74:41:
				// staticVarClassElementStmt
			{
				pushFollow(FOLLOW_staticVarClassElementStmt_in_classElementStmt434);
				staticVarClassElementStmt();
				_fsp--;

			}
				break;
			case 3:
				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:75:4:
				// methodClassElementStmt
			{
				pushFollow(FOLLOW_methodClassElementStmt_in_classElementStmt440);
				methodClassElementStmt();
				_fsp--;

			}
				break;
			case 4:
				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:75:29:
				// abstractMethodClassElementStmt
			{
				pushFollow(FOLLOW_abstractMethodClassElementStmt_in_classElementStmt444);
				abstractMethodClassElementStmt();
				_fsp--;

			}
				break;
			case 5:
				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:75:62:
				// staticMethodClassElementStmt
			{
				pushFollow(FOLLOW_staticMethodClassElementStmt_in_classElementStmt448);
				staticMethodClassElementStmt();
				_fsp--;

			}
				break;
			case 6:
				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:75:93:
				// aggStmt
			{
				pushFollow(FOLLOW_aggStmt_in_classElementStmt452);
				aggStmt();
				_fsp--;

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}

	// $ANTLR end classElementStmt

	// $ANTLR start interfaceElementStmt
	// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:77:1:
	// interfaceElementStmt : ( methodClassElementStmt |
	// staticMethodClassElementStmt );
	public final void interfaceElementStmt() throws RecognitionException {
		try {
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:77:21:
			// ( methodClassElementStmt | staticMethodClassElementStmt )
			int alt27 = 2;
			int LA27_0 = input.LA(1);

			if ((LA27_0 == ID || (LA27_0 >= 34 && LA27_0 <= 36))) {
				alt27 = 1;
			} else if ((LA27_0 == 30)) {
				alt27 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException(
						"77:1: interfaceElementStmt : ( methodClassElementStmt | staticMethodClassElementStmt );",
						27, 0, input);

				throw nvae;
			}
			switch (alt27) {
			case 1:
				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:77:23:
				// methodClassElementStmt
			{
				pushFollow(FOLLOW_methodClassElementStmt_in_interfaceElementStmt459);
				methodClassElementStmt();
				_fsp--;

			}
				break;
			case 2:
				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:77:48:
				// staticMethodClassElementStmt
			{
				pushFollow(FOLLOW_staticMethodClassElementStmt_in_interfaceElementStmt463);
				staticMethodClassElementStmt();
				_fsp--;

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}

	// $ANTLR end interfaceElementStmt

	// $ANTLR start varClassElementStmt
	// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:79:1:
	// varClassElementStmt : var ';' ;
	public final void varClassElementStmt() throws RecognitionException {
		var_return var10 = null;

		try {
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:79:20:
			// ( var ';' )
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:79:22:
			// var ';'
			{
				pushFollow(FOLLOW_var_in_varClassElementStmt470);
				var10 = var();
				_fsp--;

				match(input, 18, FOLLOW_18_in_varClassElementStmt472);
				curElements.add(classFactory.createNodeElement(
						UMLMetaType.CLASS_VAR_NODE_LABEL, input.toString(
								var10.start, var10.stop)));

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}

	// $ANTLR end varClassElementStmt

	// $ANTLR start staticVarClassElementStmt
	// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:82:1:
	// staticVarClassElementStmt : 'static' var ';' ;
	public final void staticVarClassElementStmt() throws RecognitionException {
		var_return var11 = null;

		try {
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:82:26:
			// ( 'static' var ';' )
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:82:28:
			// 'static' var ';'
			{
				match(input, 30, FOLLOW_30_in_staticVarClassElementStmt483);
				pushFollow(FOLLOW_var_in_staticVarClassElementStmt485);
				var11 = var();
				_fsp--;

				match(input, 18, FOLLOW_18_in_staticVarClassElementStmt487);
				curElements.add(classFactory.createNodeElement(
						UMLMetaType.CLASS_STATIC_VAR_NODE_LABEL, input
								.toString(var11.start, var11.stop)));

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}

	// $ANTLR end staticVarClassElementStmt

	// $ANTLR start methodClassElementStmt
	// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:85:1:
	// methodClassElementStmt : method ';' ;
	public final void methodClassElementStmt() throws RecognitionException {
		method_return method12 = null;

		try {
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:85:23:
			// ( method ';' )
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:85:25:
			// method ';'
			{
				pushFollow(FOLLOW_method_in_methodClassElementStmt498);
				method12 = method();
				_fsp--;

				match(input, 18, FOLLOW_18_in_methodClassElementStmt500);
				curElements.add(classFactory.createNodeElement(
						UMLMetaType.CLASS_METHOD_NODE_LABEL, input.toString(
								method12.start, method12.stop)));

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}

	// $ANTLR end methodClassElementStmt

	// $ANTLR start abstractMethodClassElementStmt
	// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:88:1:
	// abstractMethodClassElementStmt : 'abstract' method ';' ;
	public final void abstractMethodClassElementStmt()
			throws RecognitionException {
		method_return method13 = null;

		try {
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:88:31:
			// ( 'abstract' method ';' )
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:88:33:
			// 'abstract' method ';'
			{
				match(input, 23, FOLLOW_23_in_abstractMethodClassElementStmt511);
				pushFollow(FOLLOW_method_in_abstractMethodClassElementStmt513);
				method13 = method();
				_fsp--;

				match(input, 18, FOLLOW_18_in_abstractMethodClassElementStmt515);
				curElements.add(classFactory.createNodeElement(
						UMLMetaType.CLASS_ABSTRACT_METHOD_NODE_LABEL, input
								.toString(method13.start, method13.stop)));

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}

	// $ANTLR end abstractMethodClassElementStmt

	// $ANTLR start staticMethodClassElementStmt
	// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:91:1:
	// staticMethodClassElementStmt : 'static' method ';' ;
	public final void staticMethodClassElementStmt()
			throws RecognitionException {
		method_return method14 = null;

		try {
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:91:29:
			// ( 'static' method ';' )
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:91:31:
			// 'static' method ';'
			{
				match(input, 30, FOLLOW_30_in_staticMethodClassElementStmt526);
				pushFollow(FOLLOW_method_in_staticMethodClassElementStmt528);
				method14 = method();
				_fsp--;

				match(input, 18, FOLLOW_18_in_staticMethodClassElementStmt530);
				curElements.add(classFactory.createNodeElement(
						UMLMetaType.CLASS_STATIC_METHOD_NODE_LABEL, input
								.toString(method14.start, method14.stop)));

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}

	// $ANTLR end staticMethodClassElementStmt

	// $ANTLR start aggStmt
	// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:94:1:
	// aggStmt : from= multiplicity EDGEOP to= multiplicity '(' ID ')' ';' ;
	public final void aggStmt() throws RecognitionException {
		Token ID15 = null;
		multiplicity_return from = null;

		multiplicity_return to = null;

		try {
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:94:8:
			// (from= multiplicity EDGEOP to= multiplicity '(' ID ')' ';' )
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:94:10:
			// from= multiplicity EDGEOP to= multiplicity '(' ID ')' ';'
			{
				pushFollow(FOLLOW_multiplicity_in_aggStmt543);
				from = multiplicity();
				_fsp--;

				match(input, EDGEOP, FOLLOW_EDGEOP_in_aggStmt545);
				pushFollow(FOLLOW_multiplicity_in_aggStmt549);
				to = multiplicity();
				_fsp--;

				match(input, 31, FOLLOW_31_in_aggStmt551);
				ID15 = (Token) input.LT(1);
				match(input, ID, FOLLOW_ID_in_aggStmt553);
				match(input, 32, FOLLOW_32_in_aggStmt555);
				match(input, 18, FOLLOW_18_in_aggStmt557);
				curAggs.add(input.toString(from.start, from.stop));
				curAggs.add(input.toString(to.start, to.stop));
				curAggs.add(ID15.getText());

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}

	// $ANTLR end aggStmt

	// $ANTLR start procAttributes
	// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:97:1:
	// procAttributes : '(' procAttr ( ',' procAttr )* ')' ;
	public final void procAttributes() throws RecognitionException {
		try {
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:97:15:
			// ( '(' procAttr ( ',' procAttr )* ')' )
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:97:17:
			// '(' procAttr ( ',' procAttr )* ')'
			{
				match(input, 31, FOLLOW_31_in_procAttributes567);
				pushFollow(FOLLOW_procAttr_in_procAttributes569);
				procAttr();
				_fsp--;

				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:97:30:
				// ( ',' procAttr )*
				loop28: do {
					int alt28 = 2;
					int LA28_0 = input.LA(1);

					if ((LA28_0 == 25)) {
						alt28 = 1;
					}

					switch (alt28) {
					case 1:
						// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:97:31:
						// ',' procAttr
					{
						match(input, 25, FOLLOW_25_in_procAttributes572);
						pushFollow(FOLLOW_procAttr_in_procAttributes574);
						procAttr();
						_fsp--;

					}
						break;

					default:
						break loop28;
					}
				} while (true);

				match(input, 32, FOLLOW_32_in_procAttributes578);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}

	// $ANTLR end procAttributes

	// $ANTLR start procAttr
	// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:99:1:
	// procAttr : key= ID ':' (v= INT | v= STRING ) ;
	public final void procAttr() throws RecognitionException {
		Token key = null;
		Token v = null;

		try {
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:99:9:
			// (key= ID ':' (v= INT | v= STRING ) )
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:99:11:
			// key= ID ':' (v= INT | v= STRING )
			{
				key = (Token) input.LT(1);
				match(input, ID, FOLLOW_ID_in_procAttr587);
				match(input, 33, FOLLOW_33_in_procAttr589);
				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:99:22:
				// (v= INT | v= STRING )
				int alt29 = 2;
				int LA29_0 = input.LA(1);

				if ((LA29_0 == INT)) {
					alt29 = 1;
				} else if ((LA29_0 == STRING)) {
					alt29 = 2;
				} else {
					NoViableAltException nvae = new NoViableAltException(
							"99:22: (v= INT | v= STRING )", 29, 0, input);

					throw nvae;
				}
				switch (alt29) {
				case 1:
					// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:99:23:
					// v= INT
				{
					v = (Token) input.LT(1);
					match(input, INT, FOLLOW_INT_in_procAttr594);

				}
					break;
				case 2:
					// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:99:31:
					// v= STRING
				{
					v = (Token) input.LT(1);
					match(input, STRING, FOLLOW_STRING_in_procAttr600);

				}
					break;

				}

				graph.addProcAttr(key.getText(), v.getText());

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}

	// $ANTLR end procAttr

	public static class var_return extends ParserRuleReturnScope {
	};

	// $ANTLR start var
	// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:101:1:
	// var : ( '-' | '+' | '#' )? ID ( ':' ID )? ;
	public final var_return var() throws RecognitionException {
		var_return retval = new var_return();
		retval.start = input.LT(1);

		try {
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:101:4:
			// ( ( '-' | '+' | '#' )? ID ( ':' ID )? )
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:101:6:
			// ( '-' | '+' | '#' )? ID ( ':' ID )?
			{
				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:101:6:
				// ( '-' | '+' | '#' )?
				int alt30 = 2;
				int LA30_0 = input.LA(1);

				if (((LA30_0 >= 34 && LA30_0 <= 36))) {
					alt30 = 1;
				}
				switch (alt30) {
				case 1:
					// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:
				{
					if ((input.LA(1) >= 34 && input.LA(1) <= 36)) {
						input.consume();
						errorRecovery = false;
					} else {
						MismatchedSetException mse = new MismatchedSetException(
								null, input);
						recoverFromMismatchedSet(input, mse,
								FOLLOW_set_in_var610);
						throw mse;
					}

				}
					break;

				}

				match(input, ID, FOLLOW_ID_in_var624);
				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:101:29:
				// ( ':' ID )?
				int alt31 = 2;
				int LA31_0 = input.LA(1);

				if ((LA31_0 == 33)) {
					alt31 = 1;
				}
				switch (alt31) {
				case 1:
					// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:101:30:
					// ':' ID
				{
					match(input, 33, FOLLOW_33_in_var627);
					match(input, ID, FOLLOW_ID_in_var629);

				}
					break;

				}

			}

			retval.stop = input.LT(-1);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return retval;
	}

	// $ANTLR end var

	public static class objInstance_return extends ParserRuleReturnScope {
	};

	// $ANTLR start objInstance
	// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:103:1:
	// objInstance : ( ( ID )? ':' ID | ID );
	public final objInstance_return objInstance() throws RecognitionException {
		objInstance_return retval = new objInstance_return();
		retval.start = input.LT(1);

		try {
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:103:12:
			// ( ( ID )? ':' ID | ID )
			int alt33 = 2;
			int LA33_0 = input.LA(1);

			if ((LA33_0 == ID)) {
				int LA33_1 = input.LA(2);

				if ((LA33_1 == EDGEOP || LA33_1 == 19)) {
					alt33 = 2;
				} else if ((LA33_1 == 33)) {
					alt33 = 1;
				} else {
					NoViableAltException nvae = new NoViableAltException(
							"103:1: objInstance : ( ( ID )? ':' ID | ID );",
							33, 1, input);

					throw nvae;
				}
			} else if ((LA33_0 == 33)) {
				alt33 = 1;
			} else {
				NoViableAltException nvae = new NoViableAltException(
						"103:1: objInstance : ( ( ID )? ':' ID | ID );", 33, 0,
						input);

				throw nvae;
			}
			switch (alt33) {
			case 1:
				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:103:14:
				// ( ID )? ':' ID
			{
				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:103:14:
				// ( ID )?
				int alt32 = 2;
				int LA32_0 = input.LA(1);

				if ((LA32_0 == ID)) {
					alt32 = 1;
				}
				switch (alt32) {
				case 1:
					// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:103:14:
					// ID
				{
					match(input, ID, FOLLOW_ID_in_objInstance638);

				}
					break;

				}

				match(input, 33, FOLLOW_33_in_objInstance641);
				match(input, ID, FOLLOW_ID_in_objInstance643);

			}
				break;
			case 2:
				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:103:27:
				// ID
			{
				match(input, ID, FOLLOW_ID_in_objInstance647);

			}
				break;

			}
			retval.stop = input.LT(-1);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return retval;
	}

	// $ANTLR end objInstance

	public static class method_return extends ParserRuleReturnScope {
	};

	// $ANTLR start method
	// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:105:1:
	// method : ( '-' | '+' | '#' )? ID '(' ( ID ( ',' ID )* )? ')' ( ':' ID )?
	// ;
	public final method_return method() throws RecognitionException {
		method_return retval = new method_return();
		retval.start = input.LT(1);

		try {
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:105:7:
			// ( ( '-' | '+' | '#' )? ID '(' ( ID ( ',' ID )* )? ')' ( ':' ID )?
			// )
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:105:9:
			// ( '-' | '+' | '#' )? ID '(' ( ID ( ',' ID )* )? ')' ( ':' ID )?
			{
				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:105:9:
				// ( '-' | '+' | '#' )?
				int alt34 = 2;
				int LA34_0 = input.LA(1);

				if (((LA34_0 >= 34 && LA34_0 <= 36))) {
					alt34 = 1;
				}
				switch (alt34) {
				case 1:
					// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:
				{
					if ((input.LA(1) >= 34 && input.LA(1) <= 36)) {
						input.consume();
						errorRecovery = false;
					} else {
						MismatchedSetException mse = new MismatchedSetException(
								null, input);
						recoverFromMismatchedSet(input, mse,
								FOLLOW_set_in_method654);
						throw mse;
					}

				}
					break;

				}

				match(input, ID, FOLLOW_ID_in_method668);
				match(input, 31, FOLLOW_31_in_method670);
				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:105:36:
				// ( ID ( ',' ID )* )?
				int alt36 = 2;
				int LA36_0 = input.LA(1);

				if ((LA36_0 == ID)) {
					alt36 = 1;
				}
				switch (alt36) {
				case 1:
					// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:105:37:
					// ID ( ',' ID )*
				{
					match(input, ID, FOLLOW_ID_in_method673);
					// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:105:40:
					// ( ',' ID )*
					loop35: do {
						int alt35 = 2;
						int LA35_0 = input.LA(1);

						if ((LA35_0 == 25)) {
							alt35 = 1;
						}

						switch (alt35) {
						case 1:
							// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:105:41:
							// ',' ID
						{
							match(input, 25, FOLLOW_25_in_method676);
							match(input, ID, FOLLOW_ID_in_method678);

						}
							break;

						default:
							break loop35;
						}
					} while (true);

				}
					break;

				}

				match(input, 32, FOLLOW_32_in_method684);
				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:105:56:
				// ( ':' ID )?
				int alt37 = 2;
				int LA37_0 = input.LA(1);

				if ((LA37_0 == 33)) {
					alt37 = 1;
				}
				switch (alt37) {
				case 1:
					// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:105:57:
					// ':' ID
				{
					match(input, 33, FOLLOW_33_in_method687);
					match(input, ID, FOLLOW_ID_in_method689);

				}
					break;

				}

			}

			retval.stop = input.LT(-1);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return retval;
	}

	// $ANTLR end method

	public static class multiplicity_return extends ParserRuleReturnScope {
	};

	// $ANTLR start multiplicity
	// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:107:1:
	// multiplicity : multibound ( '..' multibound )? ;
	public final multiplicity_return multiplicity() throws RecognitionException {
		multiplicity_return retval = new multiplicity_return();
		retval.start = input.LT(1);

		try {
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:107:13:
			// ( multibound ( '..' multibound )? )
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:107:15:
			// multibound ( '..' multibound )?
			{
				pushFollow(FOLLOW_multibound_in_multiplicity698);
				multibound();
				_fsp--;

				// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:107:26:
				// ( '..' multibound )?
				int alt38 = 2;
				int LA38_0 = input.LA(1);

				if ((LA38_0 == 37)) {
					alt38 = 1;
				}
				switch (alt38) {
				case 1:
					// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:107:27:
					// '..' multibound
				{
					match(input, 37, FOLLOW_37_in_multiplicity701);
					pushFollow(FOLLOW_multibound_in_multiplicity703);
					multibound();
					_fsp--;

				}
					break;

				}

			}

			retval.stop = input.LT(-1);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return retval;
	}

	// $ANTLR end multiplicity

	// $ANTLR start multibound
	// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:109:1:
	// multibound : ( '*' | ID | INT );
	public final void multibound() throws RecognitionException {
		try {
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:109:11:
			// ( '*' | ID | INT )
			// C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\uml\\UML.g:
			{
				if (input.LA(1) == ID || input.LA(1) == INT
						|| input.LA(1) == 38) {
					input.consume();
					errorRecovery = false;
				} else {
					MismatchedSetException mse = new MismatchedSetException(
							null, input);
					recoverFromMismatchedSet(input, mse,
							FOLLOW_set_in_multibound0);
					throw mse;
				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
		}
		return;
	}

	// $ANTLR end multibound

	public static final BitSet FOLLOW_classDiagram_in_diagram50 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_collabDiagram_in_diagram54 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_seqDiagram_in_diagram58 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_set_in_collabDiagram80 = new BitSet(
			new long[] { 0x0000000000008010L });
	public static final BitSet FOLLOW_15_in_collabDiagram92 = new BitSet(
			new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_ID_in_collabDiagram95 = new BitSet(
			new long[] { 0x0000000080010000L });
	public static final BitSet FOLLOW_procAttributes_in_collabDiagram97 = new BitSet(
			new long[] { 0x0000000000010000L });
	public static final BitSet FOLLOW_16_in_collabDiagram100 = new BitSet(
			new long[] { 0x0000000200020010L });
	public static final BitSet FOLLOW_collabStmt_in_collabDiagram102 = new BitSet(
			new long[] { 0x0000000200020010L });
	public static final BitSet FOLLOW_17_in_collabDiagram105 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_objInstance_in_collabStmt114 = new BitSet(
			new long[] { 0x0000000000000020L });
	public static final BitSet FOLLOW_collab2Stmt_in_collabStmt116 = new BitSet(
			new long[] { 0x0000000000040020L });
	public static final BitSet FOLLOW_18_in_collabStmt119 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_EDGEOP_in_collab2Stmt131 = new BitSet(
			new long[] { 0x0000000200000010L });
	public static final BitSet FOLLOW_objInstance_in_collab2Stmt133 = new BitSet(
			new long[] { 0x0000000000080000L });
	public static final BitSet FOLLOW_19_in_collab2Stmt135 = new BitSet(
			new long[] { 0x0000001C00000010L });
	public static final BitSet FOLLOW_method_in_collab2Stmt137 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_set_in_seqDiagram170 = new BitSet(
			new long[] { 0x0000000000008010L });
	public static final BitSet FOLLOW_15_in_seqDiagram178 = new BitSet(
			new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_ID_in_seqDiagram181 = new BitSet(
			new long[] { 0x0000000080010000L });
	public static final BitSet FOLLOW_procAttributes_in_seqDiagram183 = new BitSet(
			new long[] { 0x0000000000010000L });
	public static final BitSet FOLLOW_16_in_seqDiagram186 = new BitSet(
			new long[] { 0x0000000200020010L });
	public static final BitSet FOLLOW_seqStmt_in_seqDiagram188 = new BitSet(
			new long[] { 0x0000000200020010L });
	public static final BitSet FOLLOW_17_in_seqDiagram191 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_objInstance_in_seqStmt200 = new BitSet(
			new long[] { 0x0000000000000020L });
	public static final BitSet FOLLOW_seq2Stmt_in_seqStmt202 = new BitSet(
			new long[] { 0x0000000000040020L });
	public static final BitSet FOLLOW_18_in_seqStmt205 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_EDGEOP_in_seq2Stmt217 = new BitSet(
			new long[] { 0x0000000200000010L });
	public static final BitSet FOLLOW_objInstance_in_seq2Stmt219 = new BitSet(
			new long[] { 0x0000000000080000L });
	public static final BitSet FOLLOW_19_in_seq2Stmt221 = new BitSet(
			new long[] { 0x0000001C00000010L });
	public static final BitSet FOLLOW_method_in_seq2Stmt223 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_22_in_classDiagram248 = new BitSet(
			new long[] { 0x0000000000008010L });
	public static final BitSet FOLLOW_15_in_classDiagram250 = new BitSet(
			new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_ID_in_classDiagram253 = new BitSet(
			new long[] { 0x0000000080010000L });
	public static final BitSet FOLLOW_procAttributes_in_classDiagram255 = new BitSet(
			new long[] { 0x0000000000010000L });
	public static final BitSet FOLLOW_16_in_classDiagram258 = new BitSet(
			new long[] { 0x0000000020C20000L });
	public static final BitSet FOLLOW_classStmt_in_classDiagram261 = new BitSet(
			new long[] { 0x0000000020C20000L });
	public static final BitSet FOLLOW_interfaceStmt_in_classDiagram265 = new BitSet(
			new long[] { 0x0000000020C20000L });
	public static final BitSet FOLLOW_17_in_classDiagram269 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_23_in_classStmt281 = new BitSet(
			new long[] { 0x0000000000400000L });
	public static final BitSet FOLLOW_22_in_classStmt285 = new BitSet(
			new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_ID_in_classStmt289 = new BitSet(
			new long[] { 0x0000000019010000L });
	public static final BitSet FOLLOW_24_in_classStmt292 = new BitSet(
			new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_ID_in_classStmt296 = new BitSet(
			new long[] { 0x0000000006000000L });
	public static final BitSet FOLLOW_25_in_classStmt299 = new BitSet(
			new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_ID_in_classStmt303 = new BitSet(
			new long[] { 0x0000000006000000L });
	public static final BitSet FOLLOW_26_in_classStmt307 = new BitSet(
			new long[] { 0x0000000018010000L });
	public static final BitSet FOLLOW_27_in_classStmt313 = new BitSet(
			new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_ID_in_classStmt317 = new BitSet(
			new long[] { 0x0000000012010000L });
	public static final BitSet FOLLOW_25_in_classStmt320 = new BitSet(
			new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_ID_in_classStmt324 = new BitSet(
			new long[] { 0x0000000012010000L });
	public static final BitSet FOLLOW_28_in_classStmt331 = new BitSet(
			new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_ID_in_classStmt335 = new BitSet(
			new long[] { 0x0000000002010000L });
	public static final BitSet FOLLOW_25_in_classStmt338 = new BitSet(
			new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_ID_in_classStmt342 = new BitSet(
			new long[] { 0x0000000002010000L });
	public static final BitSet FOLLOW_16_in_classStmt350 = new BitSet(
			new long[] { 0x0000005C40820050L });
	public static final BitSet FOLLOW_classElementStmt_in_classStmt352 = new BitSet(
			new long[] { 0x0000005C40820050L });
	public static final BitSet FOLLOW_17_in_classStmt355 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_29_in_interfaceStmt366 = new BitSet(
			new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_ID_in_interfaceStmt370 = new BitSet(
			new long[] { 0x0000000009010000L });
	public static final BitSet FOLLOW_24_in_interfaceStmt373 = new BitSet(
			new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_ID_in_interfaceStmt377 = new BitSet(
			new long[] { 0x0000000006000000L });
	public static final BitSet FOLLOW_25_in_interfaceStmt380 = new BitSet(
			new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_ID_in_interfaceStmt384 = new BitSet(
			new long[] { 0x0000000006000000L });
	public static final BitSet FOLLOW_26_in_interfaceStmt388 = new BitSet(
			new long[] { 0x0000000008010000L });
	public static final BitSet FOLLOW_27_in_interfaceStmt395 = new BitSet(
			new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_ID_in_interfaceStmt399 = new BitSet(
			new long[] { 0x0000000002010000L });
	public static final BitSet FOLLOW_25_in_interfaceStmt402 = new BitSet(
			new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_ID_in_interfaceStmt406 = new BitSet(
			new long[] { 0x0000000002010000L });
	public static final BitSet FOLLOW_16_in_interfaceStmt412 = new BitSet(
			new long[] { 0x0000001C40020010L });
	public static final BitSet FOLLOW_interfaceElementStmt_in_interfaceStmt414 = new BitSet(
			new long[] { 0x0000001C40020010L });
	public static final BitSet FOLLOW_17_in_interfaceStmt417 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_varClassElementStmt_in_classElementStmt430 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_staticVarClassElementStmt_in_classElementStmt434 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_methodClassElementStmt_in_classElementStmt440 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_abstractMethodClassElementStmt_in_classElementStmt444 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_staticMethodClassElementStmt_in_classElementStmt448 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_aggStmt_in_classElementStmt452 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_methodClassElementStmt_in_interfaceElementStmt459 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_staticMethodClassElementStmt_in_interfaceElementStmt463 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_var_in_varClassElementStmt470 = new BitSet(
			new long[] { 0x0000000000040000L });
	public static final BitSet FOLLOW_18_in_varClassElementStmt472 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_30_in_staticVarClassElementStmt483 = new BitSet(
			new long[] { 0x0000001C00000010L });
	public static final BitSet FOLLOW_var_in_staticVarClassElementStmt485 = new BitSet(
			new long[] { 0x0000000000040000L });
	public static final BitSet FOLLOW_18_in_staticVarClassElementStmt487 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_method_in_methodClassElementStmt498 = new BitSet(
			new long[] { 0x0000000000040000L });
	public static final BitSet FOLLOW_18_in_methodClassElementStmt500 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_23_in_abstractMethodClassElementStmt511 = new BitSet(
			new long[] { 0x0000001C00000010L });
	public static final BitSet FOLLOW_method_in_abstractMethodClassElementStmt513 = new BitSet(
			new long[] { 0x0000000000040000L });
	public static final BitSet FOLLOW_18_in_abstractMethodClassElementStmt515 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_30_in_staticMethodClassElementStmt526 = new BitSet(
			new long[] { 0x0000001C00000010L });
	public static final BitSet FOLLOW_method_in_staticMethodClassElementStmt528 = new BitSet(
			new long[] { 0x0000000000040000L });
	public static final BitSet FOLLOW_18_in_staticMethodClassElementStmt530 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_multiplicity_in_aggStmt543 = new BitSet(
			new long[] { 0x0000000000000020L });
	public static final BitSet FOLLOW_EDGEOP_in_aggStmt545 = new BitSet(
			new long[] { 0x0000004000000050L });
	public static final BitSet FOLLOW_multiplicity_in_aggStmt549 = new BitSet(
			new long[] { 0x0000000080000000L });
	public static final BitSet FOLLOW_31_in_aggStmt551 = new BitSet(
			new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_ID_in_aggStmt553 = new BitSet(
			new long[] { 0x0000000100000000L });
	public static final BitSet FOLLOW_32_in_aggStmt555 = new BitSet(
			new long[] { 0x0000000000040000L });
	public static final BitSet FOLLOW_18_in_aggStmt557 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_31_in_procAttributes567 = new BitSet(
			new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_procAttr_in_procAttributes569 = new BitSet(
			new long[] { 0x0000000102000000L });
	public static final BitSet FOLLOW_25_in_procAttributes572 = new BitSet(
			new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_procAttr_in_procAttributes574 = new BitSet(
			new long[] { 0x0000000102000000L });
	public static final BitSet FOLLOW_32_in_procAttributes578 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ID_in_procAttr587 = new BitSet(
			new long[] { 0x0000000200000000L });
	public static final BitSet FOLLOW_33_in_procAttr589 = new BitSet(
			new long[] { 0x00000000000000C0L });
	public static final BitSet FOLLOW_INT_in_procAttr594 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_STRING_in_procAttr600 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_set_in_var610 = new BitSet(
			new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_ID_in_var624 = new BitSet(
			new long[] { 0x0000000200000002L });
	public static final BitSet FOLLOW_33_in_var627 = new BitSet(
			new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_ID_in_var629 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ID_in_objInstance638 = new BitSet(
			new long[] { 0x0000000200000000L });
	public static final BitSet FOLLOW_33_in_objInstance641 = new BitSet(
			new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_ID_in_objInstance643 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ID_in_objInstance647 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_set_in_method654 = new BitSet(
			new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_ID_in_method668 = new BitSet(
			new long[] { 0x0000000080000000L });
	public static final BitSet FOLLOW_31_in_method670 = new BitSet(
			new long[] { 0x0000000100000010L });
	public static final BitSet FOLLOW_ID_in_method673 = new BitSet(
			new long[] { 0x0000000102000000L });
	public static final BitSet FOLLOW_25_in_method676 = new BitSet(
			new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_ID_in_method678 = new BitSet(
			new long[] { 0x0000000102000000L });
	public static final BitSet FOLLOW_32_in_method684 = new BitSet(
			new long[] { 0x0000000200000002L });
	public static final BitSet FOLLOW_33_in_method687 = new BitSet(
			new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_ID_in_method689 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_multibound_in_multiplicity698 = new BitSet(
			new long[] { 0x0000002000000002L });
	public static final BitSet FOLLOW_37_in_multiplicity701 = new BitSet(
			new long[] { 0x0000004000000050L });
	public static final BitSet FOLLOW_multibound_in_multiplicity703 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_set_in_multibound0 = new BitSet(
			new long[] { 0x0000000000000002L });

}