/* A Bison parser, made by GNU Bison 3.8.2.  */

/* Skeleton implementation for Bison LALR(1) parsers in Java

   Copyright (C) 2007-2015, 2018-2021 Free Software Foundation, Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <https://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

/* DO NOT RELY ON FEATURES THAT ARE NOT DOCUMENTED in the manual,
   especially those whose name start with YY_ or yy_.  They are
   private implementation details that can be changed or removed.  */



package compiler.parser;
import java.text.MessageFormat;
import java.util.ArrayList;
/* "%code imports" blocks.  */
/* "./parser/pythonparser.y":6  */

  import compiler.lexer.Lexer;
  import compiler.lexer.Token;
  import compiler.lexer.Tokens;

/* "./src/compiler/parser/Parser.java":50  */

/**
 * A Bison parser, automatically generated from <tt>./parser/pythonparser.y</tt>.
 *
 * @author LALR (1) parser skeleton written by Paolo Bonzini.
 */
public class Parser
{
  /** Version number for the Bison executable that generated this parser.  */
  public static final String bisonVersion = "3.8.2";

  /** Name of the skeleton that generated this parser.  */
  public static final String bisonSkeleton = "lalr1.java";






  public enum SymbolKind
  {
    S_YYEOF(0),                    /* "end of file"  */
    S_YYerror(1),                  /* error  */
    S_YYUNDEF(2),                  /* "invalid token"  */
    S_KEYWORD(3),                  /* KEYWORD  */
    S_INDENT(4),                   /* INDENT  */
    S_DEDENT(5),                   /* DEDENT  */
    S_NEWLINE(6),                  /* NEWLINE  */
    S_NUMBER(7),                   /* NUMBER  */
    S_COMMENT(8),                  /* COMMENT  */
    S_LESS_THAN_OR_EQUAL(9),       /* LESS_THAN_OR_EQUAL  */
    S_GREATER_THAN_OR_EQUAL(10),   /* GREATER_THAN_OR_EQUAL  */
    S_EQUAL(11),                   /* EQUAL  */
    S_NOT_EQUAL(12),               /* NOT_EQUAL  */
    S_NOT_EQUAL_2(13),             /* NOT_EQUAL_2  */
    S_BITWISE_SHIFT_LEFT(14),      /* BITWISE_SHIFT_LEFT  */
    S_BITWISE_SHIFT_RIGHT(15),     /* BITWISE_SHIFT_RIGHT  */
    S_POWER(16),                   /* POWER  */
    S_ADDITION_ASSIGNMENT(17),     /* ADDITION_ASSIGNMENT  */
    S_SUBSTRACTION_ASSIGNMENT(18), /* SUBSTRACTION_ASSIGNMENT  */
    S_MULTIPLICATION_ASSIGNMENT(19), /* MULTIPLICATION_ASSIGNMENT  */
    S_DIVISION_ASSIGNMENT(20),     /* DIVISION_ASSIGNMENT  */
    S_REMAINDER_ASSIGNMENT(21),    /* REMAINDER_ASSIGNMENT  */
    S_BITWISE_AND_ASSIGNMENT(22),  /* BITWISE_AND_ASSIGNMENT  */
    S_POWER_ASSIGNMENT(23),        /* POWER_ASSIGNMENT  */
    S_BITWISE_OR_ASSIGNMENT(24),   /* BITWISE_OR_ASSIGNMENT  */
    S_BITWISE_XOR_ASSIGNMENT(25),  /* BITWISE_XOR_ASSIGNMENT  */
    S_BITWISE_SHIFT_LEFT_ASSIGNMENT(26), /* BITWISE_SHIFT_LEFT_ASSIGNMENT  */
    S_BITWISE_SHIFT_RIGHT_ASSIGNMENT(27), /* BITWISE_SHIFT_RIGHT_ASSIGNMENT  */
    S_FLOOR_DIVISION(28),          /* FLOOR_DIVISION  */
    S_FLOOR_DIVISION_ASSIGNMENT(29), /* FLOOR_DIVISION_ASSIGNMENT  */
    S_BACKSLASH_LOGICAL_LINE(30),  /* BACKSLASH_LOGICAL_LINE  */
    S_STRING(31),                  /* STRING  */
    S_IDENTIFIER(32),              /* IDENTIFIER  */
    S_WHITE_SPACE(33),             /* WHITE_SPACE  */
    S_ILLEGAL(34),                 /* ILLEGAL  */
    S_IMPORT(35),                  /* IMPORT  */
    S_NONLOCAL(36),                /* NONLOCAL  */
    S_CONTINUE(37),                /* CONTINUE  */
    S_NONE(38),                    /* NONE  */
    S_GLOBAL(39),                  /* GLOBAL  */
    S_IN(40),                      /* IN  */
    S_RETURN(41),                  /* RETURN  */
    S_FALSE_TOK(42),               /* FALSE_TOK  */
    S_TRUE_TOK(43),                /* TRUE_TOK  */
    S_AND(44),                     /* AND  */
    S_OR(45),                      /* OR  */
    S_NOT(46),                     /* NOT  */
    S_DEF(47),                     /* DEF  */
    S_IF(48),                      /* IF  */
    S_ELSE(49),                    /* ELSE  */
    S_ELIF(50),                    /* ELIF  */
    S_FOR(51),                     /* FOR  */
    S_WHILE(52),                   /* WHILE  */
    S_BREAK(53),                   /* BREAK  */
    S_PASS(54),                    /* PASS  */
    S_LAMBDA(55),                  /* LAMBDA  */
    S_COMMA_LOGICAL_LINE(56),      /* COMMA_LOGICAL_LINE  */
    S_57_(57),                     /* '+'  */
    S_58_(58),                     /* '-'  */
    S_59_(59),                     /* '*'  */
    S_60_(60),                     /* '/'  */
    S_NEG(61),                     /* NEG  */
    S_62_(62),                     /* '^'  */
    S_63_n_(63),                   /* '\n'  */
    S_64_(64),                     /* '('  */
    S_65_(65),                     /* ')'  */
    S_YYACCEPT(66),                /* $accept  */
    S_prog(67),                    /* prog  */
    S_statement(68),               /* statement  */
    S_exp(69);                     /* exp  */


    private final int yycode_;

    SymbolKind (int n) {
      this.yycode_ = n;
    }

    private static final SymbolKind[] values_ = {
      SymbolKind.S_YYEOF,
      SymbolKind.S_YYerror,
      SymbolKind.S_YYUNDEF,
      SymbolKind.S_KEYWORD,
      SymbolKind.S_INDENT,
      SymbolKind.S_DEDENT,
      SymbolKind.S_NEWLINE,
      SymbolKind.S_NUMBER,
      SymbolKind.S_COMMENT,
      SymbolKind.S_LESS_THAN_OR_EQUAL,
      SymbolKind.S_GREATER_THAN_OR_EQUAL,
      SymbolKind.S_EQUAL,
      SymbolKind.S_NOT_EQUAL,
      SymbolKind.S_NOT_EQUAL_2,
      SymbolKind.S_BITWISE_SHIFT_LEFT,
      SymbolKind.S_BITWISE_SHIFT_RIGHT,
      SymbolKind.S_POWER,
      SymbolKind.S_ADDITION_ASSIGNMENT,
      SymbolKind.S_SUBSTRACTION_ASSIGNMENT,
      SymbolKind.S_MULTIPLICATION_ASSIGNMENT,
      SymbolKind.S_DIVISION_ASSIGNMENT,
      SymbolKind.S_REMAINDER_ASSIGNMENT,
      SymbolKind.S_BITWISE_AND_ASSIGNMENT,
      SymbolKind.S_POWER_ASSIGNMENT,
      SymbolKind.S_BITWISE_OR_ASSIGNMENT,
      SymbolKind.S_BITWISE_XOR_ASSIGNMENT,
      SymbolKind.S_BITWISE_SHIFT_LEFT_ASSIGNMENT,
      SymbolKind.S_BITWISE_SHIFT_RIGHT_ASSIGNMENT,
      SymbolKind.S_FLOOR_DIVISION,
      SymbolKind.S_FLOOR_DIVISION_ASSIGNMENT,
      SymbolKind.S_BACKSLASH_LOGICAL_LINE,
      SymbolKind.S_STRING,
      SymbolKind.S_IDENTIFIER,
      SymbolKind.S_WHITE_SPACE,
      SymbolKind.S_ILLEGAL,
      SymbolKind.S_IMPORT,
      SymbolKind.S_NONLOCAL,
      SymbolKind.S_CONTINUE,
      SymbolKind.S_NONE,
      SymbolKind.S_GLOBAL,
      SymbolKind.S_IN,
      SymbolKind.S_RETURN,
      SymbolKind.S_FALSE_TOK,
      SymbolKind.S_TRUE_TOK,
      SymbolKind.S_AND,
      SymbolKind.S_OR,
      SymbolKind.S_NOT,
      SymbolKind.S_DEF,
      SymbolKind.S_IF,
      SymbolKind.S_ELSE,
      SymbolKind.S_ELIF,
      SymbolKind.S_FOR,
      SymbolKind.S_WHILE,
      SymbolKind.S_BREAK,
      SymbolKind.S_PASS,
      SymbolKind.S_LAMBDA,
      SymbolKind.S_COMMA_LOGICAL_LINE,
      SymbolKind.S_57_,
      SymbolKind.S_58_,
      SymbolKind.S_59_,
      SymbolKind.S_60_,
      SymbolKind.S_NEG,
      SymbolKind.S_62_,
      SymbolKind.S_63_n_,
      SymbolKind.S_64_,
      SymbolKind.S_65_,
      SymbolKind.S_YYACCEPT,
      SymbolKind.S_prog,
      SymbolKind.S_statement,
      SymbolKind.S_exp
    };

    static final SymbolKind get(int code) {
      return values_[code];
    }

    public final int getCode() {
      return this.yycode_;
    }

    /* Return YYSTR after stripping away unnecessary quotes and
       backslashes, so that it's suitable for yyerror.  The heuristic is
       that double-quoting is unnecessary unless the string contains an
       apostrophe, a comma, or backslash (other than backslash-backslash).
       YYSTR is taken from yytname.  */
    private static String yytnamerr_(String yystr)
    {
      if (yystr.charAt (0) == '"')
        {
          StringBuffer yyr = new StringBuffer();
          strip_quotes: for (int i = 1; i < yystr.length(); i++)
            switch (yystr.charAt(i))
              {
              case '\'':
              case ',':
                break strip_quotes;

              case '\\':
                if (yystr.charAt(++i) != '\\')
                  break strip_quotes;
                /* Fall through.  */
              default:
                yyr.append(yystr.charAt(i));
                break;

              case '"':
                return yyr.toString();
              }
        }
      return yystr;
    }

    /* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
       First, the terminals, then, starting at \a YYNTOKENS_, nonterminals.  */
    private static final String[] yytname_ = yytname_init();
  private static final String[] yytname_init()
  {
    return new String[]
    {
  "\"end of file\"", "error", "\"invalid token\"", "KEYWORD", "INDENT",
  "DEDENT", "NEWLINE", "NUMBER", "COMMENT", "LESS_THAN_OR_EQUAL",
  "GREATER_THAN_OR_EQUAL", "EQUAL", "NOT_EQUAL", "NOT_EQUAL_2",
  "BITWISE_SHIFT_LEFT", "BITWISE_SHIFT_RIGHT", "POWER",
  "ADDITION_ASSIGNMENT", "SUBSTRACTION_ASSIGNMENT",
  "MULTIPLICATION_ASSIGNMENT", "DIVISION_ASSIGNMENT",
  "REMAINDER_ASSIGNMENT", "BITWISE_AND_ASSIGNMENT", "POWER_ASSIGNMENT",
  "BITWISE_OR_ASSIGNMENT", "BITWISE_XOR_ASSIGNMENT",
  "BITWISE_SHIFT_LEFT_ASSIGNMENT", "BITWISE_SHIFT_RIGHT_ASSIGNMENT",
  "FLOOR_DIVISION", "FLOOR_DIVISION_ASSIGNMENT", "BACKSLASH_LOGICAL_LINE",
  "STRING", "IDENTIFIER", "WHITE_SPACE", "ILLEGAL", "IMPORT", "NONLOCAL",
  "CONTINUE", "NONE", "GLOBAL", "IN", "RETURN", "FALSE_TOK", "TRUE_TOK",
  "AND", "OR", "NOT", "DEF", "IF", "ELSE", "ELIF", "FOR", "WHILE", "BREAK",
  "PASS", "LAMBDA", "COMMA_LOGICAL_LINE", "'+'", "'-'", "'*'", "'/'",
  "NEG", "'^'", "'\\n'", "'('", "')'", "$accept", "prog", "statement",
  "exp", null
    };
  }

    /* The user-facing name of this symbol.  */
    public final String getName() {
      return yytnamerr_(yytname_[yycode_]);
    }

  };


  /**
   * Communication interface between the scanner and the Bison-generated
   * parser <tt>Parser</tt>.
   */
  public interface Lexer {
    /* Token kinds.  */
    /** Token "end of file", to be returned by the scanner.  */
    static final int YYEOF = 0;
    /** Token error, to be returned by the scanner.  */
    static final int YYerror = 256;
    /** Token "invalid token", to be returned by the scanner.  */
    static final int YYUNDEF = 257;
    /** Token KEYWORD, to be returned by the scanner.  */
    static final int KEYWORD = 258;
    /** Token INDENT, to be returned by the scanner.  */
    static final int INDENT = 259;
    /** Token DEDENT, to be returned by the scanner.  */
    static final int DEDENT = 260;
    /** Token NEWLINE, to be returned by the scanner.  */
    static final int NEWLINE = 261;
    /** Token NUMBER, to be returned by the scanner.  */
    static final int NUMBER = 262;
    /** Token COMMENT, to be returned by the scanner.  */
    static final int COMMENT = 263;
    /** Token LESS_THAN_OR_EQUAL, to be returned by the scanner.  */
    static final int LESS_THAN_OR_EQUAL = 264;
    /** Token GREATER_THAN_OR_EQUAL, to be returned by the scanner.  */
    static final int GREATER_THAN_OR_EQUAL = 265;
    /** Token EQUAL, to be returned by the scanner.  */
    static final int EQUAL = 266;
    /** Token NOT_EQUAL, to be returned by the scanner.  */
    static final int NOT_EQUAL = 267;
    /** Token NOT_EQUAL_2, to be returned by the scanner.  */
    static final int NOT_EQUAL_2 = 268;
    /** Token BITWISE_SHIFT_LEFT, to be returned by the scanner.  */
    static final int BITWISE_SHIFT_LEFT = 269;
    /** Token BITWISE_SHIFT_RIGHT, to be returned by the scanner.  */
    static final int BITWISE_SHIFT_RIGHT = 270;
    /** Token POWER, to be returned by the scanner.  */
    static final int POWER = 271;
    /** Token ADDITION_ASSIGNMENT, to be returned by the scanner.  */
    static final int ADDITION_ASSIGNMENT = 272;
    /** Token SUBSTRACTION_ASSIGNMENT, to be returned by the scanner.  */
    static final int SUBSTRACTION_ASSIGNMENT = 273;
    /** Token MULTIPLICATION_ASSIGNMENT, to be returned by the scanner.  */
    static final int MULTIPLICATION_ASSIGNMENT = 274;
    /** Token DIVISION_ASSIGNMENT, to be returned by the scanner.  */
    static final int DIVISION_ASSIGNMENT = 275;
    /** Token REMAINDER_ASSIGNMENT, to be returned by the scanner.  */
    static final int REMAINDER_ASSIGNMENT = 276;
    /** Token BITWISE_AND_ASSIGNMENT, to be returned by the scanner.  */
    static final int BITWISE_AND_ASSIGNMENT = 277;
    /** Token POWER_ASSIGNMENT, to be returned by the scanner.  */
    static final int POWER_ASSIGNMENT = 278;
    /** Token BITWISE_OR_ASSIGNMENT, to be returned by the scanner.  */
    static final int BITWISE_OR_ASSIGNMENT = 279;
    /** Token BITWISE_XOR_ASSIGNMENT, to be returned by the scanner.  */
    static final int BITWISE_XOR_ASSIGNMENT = 280;
    /** Token BITWISE_SHIFT_LEFT_ASSIGNMENT, to be returned by the scanner.  */
    static final int BITWISE_SHIFT_LEFT_ASSIGNMENT = 281;
    /** Token BITWISE_SHIFT_RIGHT_ASSIGNMENT, to be returned by the scanner.  */
    static final int BITWISE_SHIFT_RIGHT_ASSIGNMENT = 282;
    /** Token FLOOR_DIVISION, to be returned by the scanner.  */
    static final int FLOOR_DIVISION = 283;
    /** Token FLOOR_DIVISION_ASSIGNMENT, to be returned by the scanner.  */
    static final int FLOOR_DIVISION_ASSIGNMENT = 284;
    /** Token BACKSLASH_LOGICAL_LINE, to be returned by the scanner.  */
    static final int BACKSLASH_LOGICAL_LINE = 285;
    /** Token STRING, to be returned by the scanner.  */
    static final int STRING = 286;
    /** Token IDENTIFIER, to be returned by the scanner.  */
    static final int IDENTIFIER = 287;
    /** Token WHITE_SPACE, to be returned by the scanner.  */
    static final int WHITE_SPACE = 288;
    /** Token ILLEGAL, to be returned by the scanner.  */
    static final int ILLEGAL = 289;
    /** Token IMPORT, to be returned by the scanner.  */
    static final int IMPORT = 290;
    /** Token NONLOCAL, to be returned by the scanner.  */
    static final int NONLOCAL = 291;
    /** Token CONTINUE, to be returned by the scanner.  */
    static final int CONTINUE = 292;
    /** Token NONE, to be returned by the scanner.  */
    static final int NONE = 293;
    /** Token GLOBAL, to be returned by the scanner.  */
    static final int GLOBAL = 294;
    /** Token IN, to be returned by the scanner.  */
    static final int IN = 295;
    /** Token RETURN, to be returned by the scanner.  */
    static final int RETURN = 296;
    /** Token FALSE_TOK, to be returned by the scanner.  */
    static final int FALSE_TOK = 297;
    /** Token TRUE_TOK, to be returned by the scanner.  */
    static final int TRUE_TOK = 298;
    /** Token AND, to be returned by the scanner.  */
    static final int AND = 299;
    /** Token OR, to be returned by the scanner.  */
    static final int OR = 300;
    /** Token NOT, to be returned by the scanner.  */
    static final int NOT = 301;
    /** Token DEF, to be returned by the scanner.  */
    static final int DEF = 302;
    /** Token IF, to be returned by the scanner.  */
    static final int IF = 303;
    /** Token ELSE, to be returned by the scanner.  */
    static final int ELSE = 304;
    /** Token ELIF, to be returned by the scanner.  */
    static final int ELIF = 305;
    /** Token FOR, to be returned by the scanner.  */
    static final int FOR = 306;
    /** Token WHILE, to be returned by the scanner.  */
    static final int WHILE = 307;
    /** Token BREAK, to be returned by the scanner.  */
    static final int BREAK = 308;
    /** Token PASS, to be returned by the scanner.  */
    static final int PASS = 309;
    /** Token LAMBDA, to be returned by the scanner.  */
    static final int LAMBDA = 310;
    /** Token COMMA_LOGICAL_LINE, to be returned by the scanner.  */
    static final int COMMA_LOGICAL_LINE = 311;
    /** Token NEG, to be returned by the scanner.  */
    static final int NEG = 312;

    /** Deprecated, use YYEOF instead.  */
    public static final int EOF = YYEOF;


    /**
     * Method to retrieve the semantic value of the last scanned token.
     * @return the semantic value of the last scanned token.
     */
    Object getLVal();

    /**
     * Entry point for the scanner.  Returns the token identifier corresponding
     * to the next token and prepares to return the semantic value
     * of the token.
     * @return the token identifier corresponding to the next token.
     */
    int yylex() throws java.io.IOException;

    /**
     * Emit an errorin a user-defined way.
     *
     *
     * @param msg The string for the error message.
     */
     void yyerror(String msg);


  }


  /**
   * The object doing lexical analysis for us.
   */
  private Lexer yylexer;





  /**
   * Instantiates the Bison-generated parser.
   * @param yylexer The scanner that will supply tokens to the parser.
   */
  public Parser(Lexer yylexer)
  {

    this.yylexer = yylexer;

  }



  private int yynerrs = 0;

  /**
   * The number of syntax errors so far.
   */
  public final int getNumberOfErrors() { return yynerrs; }

  /**
   * Print an error message via the lexer.
   *
   * @param msg The error message.
   */
  public final void yyerror(String msg) {
      yylexer.yyerror(msg);
  }



  private final class YYStack {
    private int[] stateStack = new int[16];
    private Object[] valueStack = new Object[16];

    public int size = 16;
    public int height = -1;

    public final void push(int state, Object value) {
      height++;
      if (size == height) {
        int[] newStateStack = new int[size * 2];
        System.arraycopy(stateStack, 0, newStateStack, 0, height);
        stateStack = newStateStack;

        Object[] newValueStack = new Object[size * 2];
        System.arraycopy(valueStack, 0, newValueStack, 0, height);
        valueStack = newValueStack;

        size *= 2;
      }

      stateStack[height] = state;
      valueStack[height] = value;
    }

    public final void pop() {
      pop(1);
    }

    public final void pop(int num) {
      // Avoid memory leaks... garbage collection is a white lie!
      if (0 < num) {
        java.util.Arrays.fill(valueStack, height - num + 1, height + 1, null);
      }
      height -= num;
    }

    public final int stateAt(int i) {
      return stateStack[height - i];
    }

    public final Object valueAt(int i) {
      return valueStack[height - i];
    }

    // Print the state stack on the debug stream.
    public void print(java.io.PrintStream out) {
      out.print ("Stack now");

      for (int i = 0; i <= height; i++) {
        out.print(' ');
        out.print(stateStack[i]);
      }
      out.println();
    }
  }

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return success (<tt>true</tt>).
   */
  public static final int YYACCEPT = 0;

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return failure (<tt>false</tt>).
   */
  public static final int YYABORT = 1;



  /**
   * Returned by a Bison action in order to start error recovery without
   * printing an error message.
   */
  public static final int YYERROR = 2;

  /**
   * Internal return codes that are not supported for user semantic
   * actions.
   */
  private static final int YYERRLAB = 3;
  private static final int YYNEWSTATE = 4;
  private static final int YYDEFAULT = 5;
  private static final int YYREDUCE = 6;
  private static final int YYERRLAB1 = 7;
  private static final int YYRETURN = 8;


  private int yyerrstatus_ = 0;


  /**
   * Whether error recovery is being done.  In this state, the parser
   * reads token until it reaches a known state, and then restarts normal
   * operation.
   */
  public final boolean recovering ()
  {
    return yyerrstatus_ == 0;
  }

  /** Compute post-reduction state.
   * @param yystate   the current state
   * @param yysym     the nonterminal to push on the stack
   */
  private int yyLRGotoState(int yystate, int yysym) {
    int yyr = yypgoto_[yysym - YYNTOKENS_] + yystate;
    if (0 <= yyr && yyr <= YYLAST_ && yycheck_[yyr] == yystate)
      return yytable_[yyr];
    else
      return yydefgoto_[yysym - YYNTOKENS_];
  }

  private int yyaction(int yyn, YYStack yystack, int yylen)
  {
    /* If YYLEN is nonzero, implement the default value of the action:
       '$$ = $1'.  Otherwise, use the top of the stack.

       Otherwise, the following line sets YYVAL to garbage.
       This behavior is undocumented and Bison
       users should not rely upon it.  */
    Object yyval = (0 < yylen) ? yystack.valueAt(yylen - 1) : yystack.valueAt(0);

    switch (yyn)
      {
          case 5: /* statement: exp '\n'  */
  if (yyn == 5)
    /* "./parser/pythonparser.y":81  */
           {System.out.println((Double)((Object)(yystack.valueAt (1))));};
  break;


  case 6: /* exp: NUMBER  */
  if (yyn == 6)
    /* "./parser/pythonparser.y":93  */
            {yyval=(Double)((Double)(yystack.valueAt (0)));};
  break;


  case 7: /* exp: exp '+' exp  */
  if (yyn == 7)
    /* "./parser/pythonparser.y":94  */
              {yyval=(Double)((Object)(yystack.valueAt (2)))+(Double)((Object)(yystack.valueAt (0)));};
  break;


  case 8: /* exp: exp '-' exp  */
  if (yyn == 8)
    /* "./parser/pythonparser.y":95  */
              {yyval=(Double)((Object)(yystack.valueAt (2)))-(Double)((Object)(yystack.valueAt (0)));};
  break;


  case 9: /* exp: exp '*' exp  */
  if (yyn == 9)
    /* "./parser/pythonparser.y":96  */
              {yyval=(Double)((Object)(yystack.valueAt (2)))*(Double)((Object)(yystack.valueAt (0)));};
  break;


  case 10: /* exp: exp '/' exp  */
  if (yyn == 10)
    /* "./parser/pythonparser.y":97  */
              {yyval=(Double)((Object)(yystack.valueAt (2)))/(Double)((Object)(yystack.valueAt (0)));};
  break;


  case 11: /* exp: '-' exp  */
  if (yyn == 11)
    /* "./parser/pythonparser.y":98  */
                    {yyval=-(Double)((Object)(yystack.valueAt (0)));};
  break;


  case 12: /* exp: '(' exp ')'  */
  if (yyn == 12)
    /* "./parser/pythonparser.y":99  */
              {yyval=((Object)(yystack.valueAt (1)));};
  break;



/* "./src/compiler/parser/Parser.java":673  */

        default: break;
      }

    yystack.pop(yylen);
    yylen = 0;
    /* Shift the result of the reduction.  */
    int yystate = yyLRGotoState(yystack.stateAt(0), yyr1_[yyn]);
    yystack.push(yystate, yyval);
    return YYNEWSTATE;
  }




  /**
   * Parse input from the scanner that was specified at object construction
   * time.  Return whether the end of the input was reached successfully.
   *
   * @return <tt>true</tt> if the parsing succeeds.  Note that this does not
   *          imply that there were no syntax errors.
   */
  public boolean parse() throws java.io.IOException

  {


    /* Lookahead token kind.  */
    int yychar = YYEMPTY_;
    /* Lookahead symbol kind.  */
    SymbolKind yytoken = null;

    /* State.  */
    int yyn = 0;
    int yylen = 0;
    int yystate = 0;
    YYStack yystack = new YYStack ();
    int label = YYNEWSTATE;



    /* Semantic value of the lookahead.  */
    Object yylval = null;



    yyerrstatus_ = 0;
    yynerrs = 0;

    /* Initialize the stack.  */
    yystack.push (yystate, yylval);



    for (;;)
      switch (label)
      {
        /* New state.  Unlike in the C/C++ skeletons, the state is already
           pushed when we come here.  */
      case YYNEWSTATE:

        /* Accept?  */
        if (yystate == YYFINAL_)
          return true;

        /* Take a decision.  First try without lookahead.  */
        yyn = yypact_[yystate];
        if (yyPactValueIsDefault (yyn))
          {
            label = YYDEFAULT;
            break;
          }

        /* Read a lookahead token.  */
        if (yychar == YYEMPTY_)
          {

            yychar = yylexer.yylex ();
            yylval = yylexer.getLVal();

          }

        /* Convert token to internal form.  */
        yytoken = yytranslate_ (yychar);

        if (yytoken == SymbolKind.S_YYerror)
          {
            // The scanner already issued an error message, process directly
            // to error recovery.  But do not keep the error token as
            // lookahead, it is too special and may lead us to an endless
            // loop in error recovery. */
            yychar = Lexer.YYUNDEF;
            yytoken = SymbolKind.S_YYUNDEF;
            label = YYERRLAB1;
          }
        else
          {
            /* If the proper action on seeing token YYTOKEN is to reduce or to
               detect an error, take that action.  */
            yyn += yytoken.getCode();
            if (yyn < 0 || YYLAST_ < yyn || yycheck_[yyn] != yytoken.getCode()) {
              label = YYDEFAULT;
            }

            /* <= 0 means reduce or error.  */
            else if ((yyn = yytable_[yyn]) <= 0)
              {
                if (yyTableValueIsError(yyn)) {
                  label = YYERRLAB;
                } else {
                  yyn = -yyn;
                  label = YYREDUCE;
                }
              }

            else
              {
                /* Shift the lookahead token.  */
                /* Discard the token being shifted.  */
                yychar = YYEMPTY_;

                /* Count tokens shifted since error; after three, turn off error
                   status.  */
                if (yyerrstatus_ > 0)
                  --yyerrstatus_;

                yystate = yyn;
                yystack.push(yystate, yylval);
                label = YYNEWSTATE;
              }
          }
        break;

      /*-----------------------------------------------------------.
      | yydefault -- do the default action for the current state.  |
      `-----------------------------------------------------------*/
      case YYDEFAULT:
        yyn = yydefact_[yystate];
        if (yyn == 0)
          label = YYERRLAB;
        else
          label = YYREDUCE;
        break;

      /*-----------------------------.
      | yyreduce -- Do a reduction.  |
      `-----------------------------*/
      case YYREDUCE:
        yylen = yyr2_[yyn];
        label = yyaction(yyn, yystack, yylen);
        yystate = yystack.stateAt(0);
        break;

      /*------------------------------------.
      | yyerrlab -- here on detecting error |
      `------------------------------------*/
      case YYERRLAB:
        /* If not already recovering from an error, report this error.  */
        if (yyerrstatus_ == 0)
          {
            ++yynerrs;
            if (yychar == YYEMPTY_)
              yytoken = null;
            yyreportSyntaxError(new Context(this, yystack, yytoken));
          }

        if (yyerrstatus_ == 3)
          {
            /* If just tried and failed to reuse lookahead token after an
               error, discard it.  */

            if (yychar <= Lexer.YYEOF)
              {
                /* Return failure if at end of input.  */
                if (yychar == Lexer.YYEOF)
                  return false;
              }
            else
              yychar = YYEMPTY_;
          }

        /* Else will try to reuse lookahead token after shifting the error
           token.  */
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------.
      | errorlab -- error raised explicitly by YYERROR.  |
      `-------------------------------------------------*/
      case YYERROR:
        /* Do not reclaim the symbols of the rule which action triggered
           this YYERROR.  */
        yystack.pop (yylen);
        yylen = 0;
        yystate = yystack.stateAt(0);
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------------------.
      | yyerrlab1 -- common code for both syntax error and YYERROR.  |
      `-------------------------------------------------------------*/
      case YYERRLAB1:
        yyerrstatus_ = 3;       /* Each real token shifted decrements this.  */

        // Pop stack until we find a state that shifts the error token.
        for (;;)
          {
            yyn = yypact_[yystate];
            if (!yyPactValueIsDefault (yyn))
              {
                yyn += SymbolKind.S_YYerror.getCode();
                if (0 <= yyn && yyn <= YYLAST_
                    && yycheck_[yyn] == SymbolKind.S_YYerror.getCode())
                  {
                    yyn = yytable_[yyn];
                    if (0 < yyn)
                      break;
                  }
              }

            /* Pop the current state because it cannot handle the
             * error token.  */
            if (yystack.height == 0)
              return false;


            yystack.pop ();
            yystate = yystack.stateAt(0);
          }

        if (label == YYABORT)
          /* Leave the switch.  */
          break;



        /* Shift the error token.  */

        yystate = yyn;
        yystack.push (yyn, yylval);
        label = YYNEWSTATE;
        break;

        /* Accept.  */
      case YYACCEPT:
        return true;

        /* Abort.  */
      case YYABORT:
        return false;
      }
}




  /**
   * Information needed to get the list of expected tokens and to forge
   * a syntax error diagnostic.
   */
  public static final class Context {
    Context(Parser parser, YYStack stack, SymbolKind token) {
      yyparser = parser;
      yystack = stack;
      yytoken = token;
    }

    private Parser yyparser;
    private YYStack yystack;


    /**
     * The symbol kind of the lookahead token.
     */
    public final SymbolKind getToken() {
      return yytoken;
    }

    private SymbolKind yytoken;
    static final int NTOKENS = Parser.YYNTOKENS_;

    /**
     * Put in YYARG at most YYARGN of the expected tokens given the
     * current YYCTX, and return the number of tokens stored in YYARG.  If
     * YYARG is null, return the number of expected tokens (guaranteed to
     * be less than YYNTOKENS).
     */
    int getExpectedTokens(SymbolKind yyarg[], int yyargn) {
      return getExpectedTokens (yyarg, 0, yyargn);
    }

    int getExpectedTokens(SymbolKind yyarg[], int yyoffset, int yyargn) {
      int yycount = yyoffset;
      int yyn = yypact_[this.yystack.stateAt(0)];
      if (!yyPactValueIsDefault(yyn))
        {
          /* Start YYX at -YYN if negative to avoid negative
             indexes in YYCHECK.  In other words, skip the first
             -YYN actions for this state because they are default
             actions.  */
          int yyxbegin = yyn < 0 ? -yyn : 0;
          /* Stay within bounds of both yycheck and yytname.  */
          int yychecklim = YYLAST_ - yyn + 1;
          int yyxend = yychecklim < NTOKENS ? yychecklim : NTOKENS;
          for (int yyx = yyxbegin; yyx < yyxend; ++yyx)
            if (yycheck_[yyx + yyn] == yyx && yyx != SymbolKind.S_YYerror.getCode()
                && !yyTableValueIsError(yytable_[yyx + yyn]))
              {
                if (yyarg == null)
                  yycount += 1;
                else if (yycount == yyargn)
                  return 0; // FIXME: this is incorrect.
                else
                  yyarg[yycount++] = SymbolKind.get(yyx);
              }
        }
      if (yyarg != null && yycount == yyoffset && yyoffset < yyargn)
        yyarg[yycount] = null;
      return yycount - yyoffset;
    }
  }





  /**
   * Build and emit a "syntax error" message in a user-defined way.
   *
   * @param yyctx  The context of the error.
   */
  private void yyreportSyntaxError(Context yyctx) {
      yyerror("syntax error");
  }

  /**
   * Whether the given <code>yypact_</code> value indicates a defaulted state.
   * @param yyvalue   the value to check
   */
  private static boolean yyPactValueIsDefault(int yyvalue) {
    return yyvalue == yypact_ninf_;
  }

  /**
   * Whether the given <code>yytable_</code>
   * value indicates a syntax error.
   * @param yyvalue the value to check
   */
  private static boolean yyTableValueIsError(int yyvalue) {
    return yyvalue == yytable_ninf_;
  }

  private static final byte yypact_ninf_ = -55;
  private static final byte yytable_ninf_ = -1;

/* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
   STATE-NUM.  */
  private static final byte[] yypact_ = yypact_init();
  private static final byte[] yypact_init()
  {
    return new byte[]
    {
      -7,   -55,    -6,   -55,    -6,     3,    -7,   -40,   -55,   -49,
     -55,   -55,    -6,    -6,    -6,    -6,   -55,   -55,   -54,   -54,
     -55,   -55
    };
  }

/* YYDEFACT[STATE-NUM] -- Default reduction number in state STATE-NUM.
   Performed when YYTABLE does not specify something else to do.  Zero
   means the default is an error.  */
  private static final byte[] yydefact_ = yydefact_init();
  private static final byte[] yydefact_init()
  {
    return new byte[]
    {
       2,     6,     0,     4,     0,     0,     2,     0,    11,     0,
       1,     3,     0,     0,     0,     0,     5,    12,     7,     8,
       9,    10
    };
  }

/* YYPGOTO[NTERM-NUM].  */
  private static final byte[] yypgoto_ = yypgoto_init();
  private static final byte[] yypgoto_init()
  {
    return new byte[]
    {
     -55,     1,   -55,     0
    };
  }

/* YYDEFGOTO[NTERM-NUM].  */
  private static final byte[] yydefgoto_ = yydefgoto_init();
  private static final byte[] yydefgoto_init()
  {
    return new byte[]
    {
       0,     5,     6,     7
    };
  }

/* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
   positive, shift that token.  If negative, reduce the rule whose
   number is the opposite.  If YYTABLE_NINF, syntax error.  */
  private static final byte[] yytable_ = yytable_init();
  private static final byte[] yytable_init()
  {
    return new byte[]
    {
       1,     1,     8,    10,     9,    14,    15,    11,    12,    13,
      14,    15,    18,    19,    20,    21,    17,    12,    13,    14,
      15,     0,     0,    16,     0,     0,     0,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     2,     2,     0,     0,     0,     3,     4,     4
    };
  }

private static final byte[] yycheck_ = yycheck_init();
  private static final byte[] yycheck_init()
  {
    return new byte[]
    {
       7,     7,     2,     0,     4,    59,    60,     6,    57,    58,
      59,    60,    12,    13,    14,    15,    65,    57,    58,    59,
      60,    -1,    -1,    63,    -1,    -1,    -1,    -1,    -1,    -1,
      -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,
      -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,
      -1,    58,    58,    -1,    -1,    -1,    63,    64,    64
    };
  }

/* YYSTOS[STATE-NUM] -- The symbol kind of the accessing symbol of
   state STATE-NUM.  */
  private static final byte[] yystos_ = yystos_init();
  private static final byte[] yystos_init()
  {
    return new byte[]
    {
       0,     7,    58,    63,    64,    67,    68,    69,    69,    69,
       0,    67,    57,    58,    59,    60,    63,    65,    69,    69,
      69,    69
    };
  }

/* YYR1[RULE-NUM] -- Symbol kind of the left-hand side of rule RULE-NUM.  */
  private static final byte[] yyr1_ = yyr1_init();
  private static final byte[] yyr1_init()
  {
    return new byte[]
    {
       0,    66,    67,    67,    68,    68,    69,    69,    69,    69,
      69,    69,    69
    };
  }

/* YYR2[RULE-NUM] -- Number of symbols on the right-hand side of rule RULE-NUM.  */
  private static final byte[] yyr2_ = yyr2_init();
  private static final byte[] yyr2_init()
  {
    return new byte[]
    {
       0,     2,     0,     2,     1,     2,     1,     3,     3,     3,
       3,     2,     3
    };
  }




  /* YYTRANSLATE_(TOKEN-NUM) -- Symbol number corresponding to TOKEN-NUM
     as returned by yylex, with out-of-bounds checking.  */
  private static final SymbolKind yytranslate_(int t)
  {
    // Last valid token kind.
    int code_max = 312;
    if (t <= 0)
      return SymbolKind.S_YYEOF;
    else if (t <= code_max)
      return SymbolKind.get(yytranslate_table_[t]);
    else
      return SymbolKind.S_YYUNDEF;
  }
  private static final byte[] yytranslate_table_ = yytranslate_table_init();
  private static final byte[] yytranslate_table_init()
  {
    return new byte[]
    {
       0,     2,     2,     2,     2,     2,     2,     2,     2,     2,
      63,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
      64,    65,    59,    57,     2,    58,     2,    60,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,    62,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     1,     2,     3,     4,
       5,     6,     7,     8,     9,    10,    11,    12,    13,    14,
      15,    16,    17,    18,    19,    20,    21,    22,    23,    24,
      25,    26,    27,    28,    29,    30,    31,    32,    33,    34,
      35,    36,    37,    38,    39,    40,    41,    42,    43,    44,
      45,    46,    47,    48,    49,    50,    51,    52,    53,    54,
      55,    56,    61
    };
  }


  private static final int YYLAST_ = 58;
  private static final int YYEMPTY_ = -2;
  private static final int YYFINAL_ = 10;
  private static final int YYNTOKENS_ = 66;


}
/* "./parser/pythonparser.y":101  */


