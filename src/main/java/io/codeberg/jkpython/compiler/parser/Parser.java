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

package io.codeberg.jkpython.compiler.parser;



import java.text.MessageFormat;
import java.util.ArrayList;
/* "%code imports" blocks.  */
/* "./parser/pythonparser.y":10  */

  import io.codeberg.jkpython.compiler.lexer.Lexer;
  import io.codeberg.jkpython.compiler.lexer.Token;
  import io.codeberg.jkpython.compiler.evaluator.source_tree.Program;
  import io.codeberg.jkpython.compiler.evaluator.source_tree.SourceNode;
  import io.codeberg.jkpython.compiler.evaluator.source_tree.statements.expressions.*;
  import io.codeberg.jkpython.compiler.evaluator.source_tree.statements.*;
  import io.codeberg.jkpython.compiler.evaluator.builtins.types.*;
  import java.util.List;
  import java.util.ArrayList;
  import kotlin.Pair;
  import io.codeberg.jkpython.compiler.evaluator.builtins.constants.*;

/* "./src/main/java/io/codeberg/jkpython/compiler/parser/Parser.java":59  */

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
  public static final String bisonSkeleton = "./parser/./lalr1-patched.java";






  public enum SymbolKind
  {
    S_YYEOF(0),                    /* "end of file"  */
    S_YYerror(1),                  /* error  */
    S_YYUNDEF(2),                  /* "invalid token"  */
    S_INDENT(3),                   /* INDENT  */
    S_DEDENT(4),                   /* DEDENT  */
    S_NEWLINE(5),                  /* NEWLINE  */
    S_NUMBER(6),                   /* NUMBER  */
    S_COMMENT(7),                  /* COMMENT  */
    S_LESS_THAN_OR_EQUAL(8),       /* LESS_THAN_OR_EQUAL  */
    S_GREATER_THAN_OR_EQUAL(9),    /* GREATER_THAN_OR_EQUAL  */
    S_EQUAL(10),                   /* EQUAL  */
    S_NOT_EQUAL(11),               /* NOT_EQUAL  */
    S_NOT_EQUAL_2(12),             /* NOT_EQUAL_2  */
    S_BITWISE_SHIFT_LEFT(13),      /* BITWISE_SHIFT_LEFT  */
    S_BITWISE_SHIFT_RIGHT(14),     /* BITWISE_SHIFT_RIGHT  */
    S_POWER(15),                   /* POWER  */
    S_ADDITION_ASSIGNMENT(16),     /* ADDITION_ASSIGNMENT  */
    S_SUBSTRACTION_ASSIGNMENT(17), /* SUBSTRACTION_ASSIGNMENT  */
    S_MULTIPLICATION_ASSIGNMENT(18), /* MULTIPLICATION_ASSIGNMENT  */
    S_DIVISION_ASSIGNMENT(19),     /* DIVISION_ASSIGNMENT  */
    S_REMAINDER_ASSIGNMENT(20),    /* REMAINDER_ASSIGNMENT  */
    S_BITWISE_AND_ASSIGNMENT(21),  /* BITWISE_AND_ASSIGNMENT  */
    S_POWER_ASSIGNMENT(22),        /* POWER_ASSIGNMENT  */
    S_BITWISE_OR_ASSIGNMENT(23),   /* BITWISE_OR_ASSIGNMENT  */
    S_BITWISE_XOR_ASSIGNMENT(24),  /* BITWISE_XOR_ASSIGNMENT  */
    S_BITWISE_SHIFT_LEFT_ASSIGNMENT(25), /* BITWISE_SHIFT_LEFT_ASSIGNMENT  */
    S_BITWISE_SHIFT_RIGHT_ASSIGNMENT(26), /* BITWISE_SHIFT_RIGHT_ASSIGNMENT  */
    S_FLOOR_DIVISION(27),          /* FLOOR_DIVISION  */
    S_FLOOR_DIVISION_ASSIGNMENT(28), /* FLOOR_DIVISION_ASSIGNMENT  */
    S_BACKSLASH_LOGICAL_LINE(29),  /* BACKSLASH_LOGICAL_LINE  */
    S_STRING(30),                  /* STRING  */
    S_IDENTIFIER(31),              /* IDENTIFIER  */
    S_WHITE_SPACE(32),             /* WHITE_SPACE  */
    S_ILLEGAL(33),                 /* ILLEGAL  */
    S_IMPORT(34),                  /* IMPORT  */
    S_NONLOCAL(35),                /* NONLOCAL  */
    S_CONTINUE(36),                /* CONTINUE  */
    S_NONE(37),                    /* NONE  */
    S_GLOBAL(38),                  /* GLOBAL  */
    S_IN(39),                      /* IN  */
    S_RETURN(40),                  /* RETURN  */
    S_FALSE_TOK(41),               /* FALSE_TOK  */
    S_TRUE_TOK(42),                /* TRUE_TOK  */
    S_AND(43),                     /* AND  */
    S_OR(44),                      /* OR  */
    S_NOT(45),                     /* NOT  */
    S_DEF(46),                     /* DEF  */
    S_IF(47),                      /* IF  */
    S_ELSE(48),                    /* ELSE  */
    S_ELIF(49),                    /* ELIF  */
    S_FOR(50),                     /* FOR  */
    S_WHILE(51),                   /* WHILE  */
    S_BREAK(52),                   /* BREAK  */
    S_PASS(53),                    /* PASS  */
    S_LAMBDA(54),                  /* LAMBDA  */
    S_COMMA_LOGICAL_LINE(55),      /* COMMA_LOGICAL_LINE  */
    S_56_(56),                     /* ','  */
    S_57_(57),                     /* '='  */
    S_58_(58),                     /* '<'  */
    S_59_(59),                     /* '>'  */
    S_60_(60),                     /* '+'  */
    S_61_(61),                     /* '-'  */
    S_62_(62),                     /* '*'  */
    S_63_(63),                     /* '/'  */
    S_64_(64),                     /* '%'  */
    S_NEG(65),                     /* NEG  */
    S_66_n_(66),                   /* '\n'  */
    S_67_(67),                     /* '('  */
    S_68_(68),                     /* ')'  */
    S_69_(69),                     /* ':'  */
    S_70_(70),                     /* '['  */
    S_71_(71),                     /* ']'  */
    S_YYACCEPT(72),                /* $accept  */
    S_prog(73),                    /* prog  */
    S_statements(74),              /* statements  */
    S_statement(75),               /* statement  */
    S_function_statement(76),      /* function_statement  */
    S_function_args(77),           /* function_args  */
    S_for_statement(78),           /* for_statement  */
    S_while_statement(79),         /* while_statement  */
    S_return_statement(80),        /* return_statement  */
    S_if_statement(81),            /* if_statement  */
    S_else_if_blocks(82),          /* else_if_blocks  */
    S_block(83),                   /* block  */
    S_exp(84),                     /* exp  */
    S_exp_list(85),                /* exp_list  */
    S_if_pred(86);                 /* if_pred  */


    private final int yycode_;

    SymbolKind (int n) {
      this.yycode_ = n;
    }

    private static final SymbolKind[] values_ = {
      SymbolKind.S_YYEOF,
      SymbolKind.S_YYerror,
      SymbolKind.S_YYUNDEF,
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
      SymbolKind.S_56_,
      SymbolKind.S_57_,
      SymbolKind.S_58_,
      SymbolKind.S_59_,
      SymbolKind.S_60_,
      SymbolKind.S_61_,
      SymbolKind.S_62_,
      SymbolKind.S_63_,
      SymbolKind.S_64_,
      SymbolKind.S_NEG,
      SymbolKind.S_66_n_,
      SymbolKind.S_67_,
      SymbolKind.S_68_,
      SymbolKind.S_69_,
      SymbolKind.S_70_,
      SymbolKind.S_71_,
      SymbolKind.S_YYACCEPT,
      SymbolKind.S_prog,
      SymbolKind.S_statements,
      SymbolKind.S_statement,
      SymbolKind.S_function_statement,
      SymbolKind.S_function_args,
      SymbolKind.S_for_statement,
      SymbolKind.S_while_statement,
      SymbolKind.S_return_statement,
      SymbolKind.S_if_statement,
      SymbolKind.S_else_if_blocks,
      SymbolKind.S_block,
      SymbolKind.S_exp,
      SymbolKind.S_exp_list,
      SymbolKind.S_if_pred
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
  "\"end of file\"", "error", "\"invalid token\"", "INDENT", "DEDENT",
  "NEWLINE", "NUMBER", "COMMENT", "LESS_THAN_OR_EQUAL",
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
  "PASS", "LAMBDA", "COMMA_LOGICAL_LINE", "','", "'='", "'<'", "'>'",
  "'+'", "'-'", "'*'", "'/'", "'%'", "NEG", "'\\n'", "'('", "')'", "':'",
  "'['", "']'", "$accept", "prog", "statements", "statement",
  "function_statement", "function_args", "for_statement",
  "while_statement", "return_statement", "if_statement", "else_if_blocks",
  "block", "exp", "exp_list", "if_pred", null
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
    /** Token INDENT, to be returned by the scanner.  */
    static final int INDENT = 258;
    /** Token DEDENT, to be returned by the scanner.  */
    static final int DEDENT = 259;
    /** Token NEWLINE, to be returned by the scanner.  */
    static final int NEWLINE = 260;
    /** Token NUMBER, to be returned by the scanner.  */
    static final int NUMBER = 261;
    /** Token COMMENT, to be returned by the scanner.  */
    static final int COMMENT = 262;
    /** Token LESS_THAN_OR_EQUAL, to be returned by the scanner.  */
    static final int LESS_THAN_OR_EQUAL = 263;
    /** Token GREATER_THAN_OR_EQUAL, to be returned by the scanner.  */
    static final int GREATER_THAN_OR_EQUAL = 264;
    /** Token EQUAL, to be returned by the scanner.  */
    static final int EQUAL = 265;
    /** Token NOT_EQUAL, to be returned by the scanner.  */
    static final int NOT_EQUAL = 266;
    /** Token NOT_EQUAL_2, to be returned by the scanner.  */
    static final int NOT_EQUAL_2 = 267;
    /** Token BITWISE_SHIFT_LEFT, to be returned by the scanner.  */
    static final int BITWISE_SHIFT_LEFT = 268;
    /** Token BITWISE_SHIFT_RIGHT, to be returned by the scanner.  */
    static final int BITWISE_SHIFT_RIGHT = 269;
    /** Token POWER, to be returned by the scanner.  */
    static final int POWER = 270;
    /** Token ADDITION_ASSIGNMENT, to be returned by the scanner.  */
    static final int ADDITION_ASSIGNMENT = 271;
    /** Token SUBSTRACTION_ASSIGNMENT, to be returned by the scanner.  */
    static final int SUBSTRACTION_ASSIGNMENT = 272;
    /** Token MULTIPLICATION_ASSIGNMENT, to be returned by the scanner.  */
    static final int MULTIPLICATION_ASSIGNMENT = 273;
    /** Token DIVISION_ASSIGNMENT, to be returned by the scanner.  */
    static final int DIVISION_ASSIGNMENT = 274;
    /** Token REMAINDER_ASSIGNMENT, to be returned by the scanner.  */
    static final int REMAINDER_ASSIGNMENT = 275;
    /** Token BITWISE_AND_ASSIGNMENT, to be returned by the scanner.  */
    static final int BITWISE_AND_ASSIGNMENT = 276;
    /** Token POWER_ASSIGNMENT, to be returned by the scanner.  */
    static final int POWER_ASSIGNMENT = 277;
    /** Token BITWISE_OR_ASSIGNMENT, to be returned by the scanner.  */
    static final int BITWISE_OR_ASSIGNMENT = 278;
    /** Token BITWISE_XOR_ASSIGNMENT, to be returned by the scanner.  */
    static final int BITWISE_XOR_ASSIGNMENT = 279;
    /** Token BITWISE_SHIFT_LEFT_ASSIGNMENT, to be returned by the scanner.  */
    static final int BITWISE_SHIFT_LEFT_ASSIGNMENT = 280;
    /** Token BITWISE_SHIFT_RIGHT_ASSIGNMENT, to be returned by the scanner.  */
    static final int BITWISE_SHIFT_RIGHT_ASSIGNMENT = 281;
    /** Token FLOOR_DIVISION, to be returned by the scanner.  */
    static final int FLOOR_DIVISION = 282;
    /** Token FLOOR_DIVISION_ASSIGNMENT, to be returned by the scanner.  */
    static final int FLOOR_DIVISION_ASSIGNMENT = 283;
    /** Token BACKSLASH_LOGICAL_LINE, to be returned by the scanner.  */
    static final int BACKSLASH_LOGICAL_LINE = 284;
    /** Token STRING, to be returned by the scanner.  */
    static final int STRING = 285;
    /** Token IDENTIFIER, to be returned by the scanner.  */
    static final int IDENTIFIER = 286;
    /** Token WHITE_SPACE, to be returned by the scanner.  */
    static final int WHITE_SPACE = 287;
    /** Token ILLEGAL, to be returned by the scanner.  */
    static final int ILLEGAL = 288;
    /** Token IMPORT, to be returned by the scanner.  */
    static final int IMPORT = 289;
    /** Token NONLOCAL, to be returned by the scanner.  */
    static final int NONLOCAL = 290;
    /** Token CONTINUE, to be returned by the scanner.  */
    static final int CONTINUE = 291;
    /** Token NONE, to be returned by the scanner.  */
    static final int NONE = 292;
    /** Token GLOBAL, to be returned by the scanner.  */
    static final int GLOBAL = 293;
    /** Token IN, to be returned by the scanner.  */
    static final int IN = 294;
    /** Token RETURN, to be returned by the scanner.  */
    static final int RETURN = 295;
    /** Token FALSE_TOK, to be returned by the scanner.  */
    static final int FALSE_TOK = 296;
    /** Token TRUE_TOK, to be returned by the scanner.  */
    static final int TRUE_TOK = 297;
    /** Token AND, to be returned by the scanner.  */
    static final int AND = 298;
    /** Token OR, to be returned by the scanner.  */
    static final int OR = 299;
    /** Token NOT, to be returned by the scanner.  */
    static final int NOT = 300;
    /** Token DEF, to be returned by the scanner.  */
    static final int DEF = 301;
    /** Token IF, to be returned by the scanner.  */
    static final int IF = 302;
    /** Token ELSE, to be returned by the scanner.  */
    static final int ELSE = 303;
    /** Token ELIF, to be returned by the scanner.  */
    static final int ELIF = 304;
    /** Token FOR, to be returned by the scanner.  */
    static final int FOR = 305;
    /** Token WHILE, to be returned by the scanner.  */
    static final int WHILE = 306;
    /** Token BREAK, to be returned by the scanner.  */
    static final int BREAK = 307;
    /** Token PASS, to be returned by the scanner.  */
    static final int PASS = 308;
    /** Token LAMBDA, to be returned by the scanner.  */
    static final int LAMBDA = 309;
    /** Token COMMA_LOGICAL_LINE, to be returned by the scanner.  */
    static final int COMMA_LOGICAL_LINE = 310;
    /** Token NEG, to be returned by the scanner.  */
    static final int NEG = 311;

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


  private class YYLexer implements Lexer {
/* "%code lexer" blocks.  */
/* "./parser/pythonparser.y":33  */

  private io.codeberg.jkpython.compiler.lexer.Lexer lexer;

  public YYLexer(io.codeberg.jkpython.compiler.lexer.Lexer lexer){
    this.lexer=lexer;
  }

  public void yyerror(String s) {
    System.err.println(s);
    System.exit(1);
  }

  private Object yylval;

  public Object getLVal() {
    return yylval;
  }

  public int yylex(){
    Token token=lexer.nextToken();
    if(token==null){
        return YYEOF;
    }
    switch(token.getType()){
      case NUMBER:
      	  //Return a literal (AST leaf that contains a primitive type) so it gets added to the AST
      	  //Literals are host language variables
          yylval=SourceNode.Companion.addMeta(new Literal(Double.parseDouble(token.getLiteral())),token.lineNum,token.colNum,null);
          return NUMBER;
      case NEWLINE:
          return (int) '\n';
      case STRING:
          String str=token.getLiteral();
          //Remove quotation marks to allow operations on strings
          if(str.startsWith("'''") || str.startsWith("\"\"\""))
          	yylval=SourceNode.Companion.addMeta(new Literal(str.substring(3,str.length()-3)),token.lineNum,token.colNum,null);
          else
          	yylval=SourceNode.Companion.addMeta(new Literal(str.substring(1,str.length()-1)),token.lineNum,token.colNum,null);
          return STRING;
      case IDENTIFIER:
          //AST node that marks an identifier (Also Identifier type is now
          //Identifier (as in the evaluator's))
          yylval=SourceNode.Companion.addMeta(new Identifier(token.getLiteral()),token.lineNum,token.colNum,null);
          return IDENTIFIER;

      case TRUE_TOK:
          yylval=SourceNode.Companion.addMeta(new Literal(true),token.lineNum,token.colNum,null);
          return TRUE_TOK;
      case FALSE_TOK:
      	  yylval=SourceNode.Companion.addMeta(new Literal(false),token.lineNum,token.colNum,null);
      	  return FALSE_TOK;
      case COMMENT:
      	  return (int) '\n'; //FIXME just anything that does nothing
      case NONE:
		   yylval=SourceNode.Companion.addMeta(new Literal(PyNone.INSTANCE),token.lineNum,token.colNum,null);
		   return NONE;
      default:
          return token.getType();
    }
  }

/* "./src/main/java/io/codeberg/jkpython/compiler/parser/Parser.java":558  */

  }


  /**
   * The object doing lexical analysis for us.
   */
  private Lexer yylexer;




  /**
   * Instantiates the Bison-generated parser.
   */
  public Parser(io.codeberg.jkpython.compiler.lexer.Lexer lexer)
  {

    this.yylexer = new YYLexer(lexer);

  }


  /**
   * Instantiates the Bison-generated parser.
   * @param yylexer The scanner that will supply tokens to the parser.
   */
  protected Parser(Lexer yylexer)
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
          case 3: /* prog: statements  */
  if (yyn == 3)
    /* "./parser/pythonparser.y":180  */
             {
	//The AST root node
	program = new Program(new StatementsBlock(((List<Statement>)(yystack.valueAt (0))).toArray(new Statement[0])));
};
  break;


  case 4: /* statements: statement  */
  if (yyn == 4)
    /* "./parser/pythonparser.y":187  */
          {yyval=new ArrayList<>(List.of(((Statement)(yystack.valueAt (0)))));};
  break;


  case 5: /* statements: statement statements  */
  if (yyn == 5)
    /* "./parser/pythonparser.y":188  */
                     {
	yyval=new ArrayList<>(List.of(((Statement)(yystack.valueAt (1)))));
	((List)(yyval)).addAll(((List<Statement>)(yystack.valueAt (0)))); //Combine all statements together
};
  break;


  case 6: /* statement: '\n'  */
  if (yyn == 6)
    /* "./parser/pythonparser.y":195  */
     {};
  break;


  case 7: /* statement: exp '\n'  */
  if (yyn == 7)
    /* "./parser/pythonparser.y":196  */
           {yyval=((Expression)(yystack.valueAt (1)));};
  break;


  case 8: /* statement: if_statement  */
  if (yyn == 8)
    /* "./parser/pythonparser.y":197  */
               {yyval=((IfStatement)(yystack.valueAt (0)));};
  break;


  case 9: /* statement: for_statement  */
  if (yyn == 9)
    /* "./parser/pythonparser.y":198  */
                {yyval=((ForStatement)(yystack.valueAt (0)));};
  break;


  case 10: /* statement: while_statement  */
  if (yyn == 10)
    /* "./parser/pythonparser.y":199  */
                  {yyval=((WhileStatement)(yystack.valueAt (0)));};
  break;


  case 11: /* statement: function_statement  */
  if (yyn == 11)
    /* "./parser/pythonparser.y":200  */
                     {yyval=((FunctionDeclaration)(yystack.valueAt (0)));};
  break;


  case 12: /* statement: return_statement  */
  if (yyn == 12)
    /* "./parser/pythonparser.y":201  */
                   {yyval=((ReturnStatement)(yystack.valueAt (0)));};
  break;


  case 13: /* statement: CONTINUE  */
  if (yyn == 13)
    /* "./parser/pythonparser.y":202  */
           {yyval=new ContinueStatement();};
  break;


  case 14: /* statement: BREAK  */
  if (yyn == 14)
    /* "./parser/pythonparser.y":203  */
        {yyval=new BreakStatement();};
  break;


  case 15: /* function_statement: DEF IDENTIFIER '(' function_args ')' ':' block  */
  if (yyn == 15)
    /* "./parser/pythonparser.y":209  */
                                             {yyval=new FunctionDeclaration(((Identifier)(yystack.valueAt (5))),((List<Identifier>)(yystack.valueAt (3))),((StatementsBlock)(yystack.valueAt (0))));};
  break;


  case 16: /* function_statement: DEF IDENTIFIER '(' ')' ':' block  */
  if (yyn == 16)
    /* "./parser/pythonparser.y":210  */
                                  {
 	yyval=new FunctionDeclaration(((Identifier)(yystack.valueAt (4))),new ArrayList<Identifier>(),((StatementsBlock)(yystack.valueAt (0)))); //Declare a function with empty arguments list
 };
  break;


  case 17: /* function_args: IDENTIFIER  */
  if (yyn == 17)
    /* "./parser/pythonparser.y":217  */
           {yyval= new ArrayList<>(List.of(((Identifier)(yystack.valueAt (0)))));};
  break;


  case 18: /* function_args: IDENTIFIER ',' function_args  */
  if (yyn == 18)
    /* "./parser/pythonparser.y":218  */
                               {
	yyval=new ArrayList<>(List.of(((Identifier)(yystack.valueAt (2)))));
    ((List)(yyval)).addAll(((List<Identifier>)(yystack.valueAt (0)))); //Combine all identifiers together
};
  break;


  case 19: /* for_statement: FOR IDENTIFIER IN exp ':' block  */
  if (yyn == 19)
    /* "./parser/pythonparser.y":225  */
                                {yyval=new ForStatement(((Identifier)(yystack.valueAt (4))),((Expression)(yystack.valueAt (2))),((StatementsBlock)(yystack.valueAt (0))));};
  break;


  case 20: /* while_statement: WHILE exp ':' block  */
  if (yyn == 20)
    /* "./parser/pythonparser.y":229  */
                   {yyval= new WhileStatement(((Expression)(yystack.valueAt (2))),((StatementsBlock)(yystack.valueAt (0))));};
  break;


  case 21: /* return_statement: RETURN '\n'  */
  if (yyn == 21)
    /* "./parser/pythonparser.y":233  */
            {yyval=new ReturnStatement();};
  break;


  case 22: /* return_statement: RETURN exp '\n'  */
  if (yyn == 22)
    /* "./parser/pythonparser.y":234  */
                 {yyval=new ReturnStatement(((Expression)(yystack.valueAt (1))));};
  break;


  case 23: /* if_statement: IF if_pred ':' block  */
  if (yyn == 23)
    /* "./parser/pythonparser.y":238  */
                     {yyval=new IfStatement(((Expression)(yystack.valueAt (2))),((StatementsBlock)(yystack.valueAt (0))),new ArrayList<Pair<Expression,StatementsBlock>>(),null);};
  break;


  case 24: /* if_statement: IF if_pred ':' block ELSE ':' block  */
  if (yyn == 24)
    /* "./parser/pythonparser.y":239  */
                                      {yyval=new IfStatement(((Expression)(yystack.valueAt (5))),((StatementsBlock)(yystack.valueAt (3))),new ArrayList<Pair<Expression,StatementsBlock>>(),((StatementsBlock)(yystack.valueAt (0))));};
  break;


  case 25: /* if_statement: IF if_pred ':' block else_if_blocks  */
  if (yyn == 25)
    /* "./parser/pythonparser.y":240  */
                                      {yyval=new IfStatement(((Expression)(yystack.valueAt (3))),((StatementsBlock)(yystack.valueAt (1))),((List<Pair<Expression,StatementsBlock>>)(yystack.valueAt (0))),null);};
  break;


  case 26: /* if_statement: IF if_pred ':' block else_if_blocks ELSE ':' block  */
  if (yyn == 26)
    /* "./parser/pythonparser.y":241  */
                                                     {yyval=new IfStatement(((Expression)(yystack.valueAt (6))),((StatementsBlock)(yystack.valueAt (4))),((List<Pair<Expression,StatementsBlock>>)(yystack.valueAt (3))),((StatementsBlock)(yystack.valueAt (0))));};
  break;


  case 27: /* else_if_blocks: ELIF if_pred ':' block  */
  if (yyn == 27)
    /* "./parser/pythonparser.y":245  */
                       {yyval= new ArrayList<>(List.of(new Pair<Expression,StatementsBlock>(((Expression)(yystack.valueAt (2))),((StatementsBlock)(yystack.valueAt (0))))));};
  break;


  case 28: /* else_if_blocks: ELIF if_pred ':' block else_if_blocks  */
  if (yyn == 28)
    /* "./parser/pythonparser.y":246  */
                                        {
	yyval=new ArrayList<>(List.of(new Pair<Expression,StatementsBlock>(((Expression)(yystack.valueAt (3))),((StatementsBlock)(yystack.valueAt (1))))));
	((List)(yyval)).addAll(((List<Pair<Expression,StatementsBlock>>)(yystack.valueAt (0)))); //Combine all else ifs together
};
  break;


  case 29: /* block: '\n' INDENT statements DEDENT  */
  if (yyn == 29)
    /* "./parser/pythonparser.y":253  */
                              {yyval=new StatementsBlock(((List<Statement>)(yystack.valueAt (1))).toArray(new Statement[0]));};
  break;


  case 30: /* exp: IDENTIFIER  */
  if (yyn == 30)
    /* "./parser/pythonparser.y":257  */
           {
	yyval=((Identifier)(yystack.valueAt (0))); //Just so types cast
};
  break;


  case 31: /* exp: TRUE_TOK  */
  if (yyn == 31)
    /* "./parser/pythonparser.y":260  */
           {
	yyval=((Literal)(yystack.valueAt (0)));
};
  break;


  case 32: /* exp: FALSE_TOK  */
  if (yyn == 32)
    /* "./parser/pythonparser.y":263  */
            {
	yyval=((Literal)(yystack.valueAt (0)));
};
  break;


  case 33: /* exp: NONE  */
  if (yyn == 33)
    /* "./parser/pythonparser.y":266  */
      {
	yyval=((Literal)(yystack.valueAt (0)));
};
  break;


  case 34: /* exp: NUMBER  */
  if (yyn == 34)
    /* "./parser/pythonparser.y":269  */
         {yyval=((Literal)(yystack.valueAt (0)));};
  break;


  case 35: /* exp: STRING  */
  if (yyn == 35)
    /* "./parser/pythonparser.y":270  */
         {yyval=((Literal)(yystack.valueAt (0)));};
  break;


  case 36: /* exp: COMMENT  */
  if (yyn == 36)
    /* "./parser/pythonparser.y":271  */
          {};
  break;


  case 37: /* exp: '[' exp_list ']'  */
  if (yyn == 37)
    /* "./parser/pythonparser.y":272  */
                   {
	yyval=new ListExpression(((List<Expression>)(yystack.valueAt (1)))); //Create a list in the host language
};
  break;


  case 38: /* exp: '[' ']'  */
  if (yyn == 38)
    /* "./parser/pythonparser.y":275  */
         {
	yyval=new ListExpression(new ArrayList<Expression>()); //Empty list
};
  break;


  case 39: /* exp: exp AND exp  */
  if (yyn == 39)
    /* "./parser/pythonparser.y":278  */
              {
	yyval=new InfixExpression(((Expression)(yystack.valueAt (2))),"&&",((Expression)(yystack.valueAt (0))));
};
  break;


  case 40: /* exp: exp OR exp  */
  if (yyn == 40)
    /* "./parser/pythonparser.y":281  */
             {
	yyval=new InfixExpression(((Expression)(yystack.valueAt (2))),"||",((Expression)(yystack.valueAt (0))));
};
  break;


  case 41: /* exp: exp EQUAL exp  */
  if (yyn == 41)
    /* "./parser/pythonparser.y":284  */
                {
				yyval= new InfixExpression(((Expression)(yystack.valueAt (2))),"==",((Expression)(yystack.valueAt (0))));
                };
  break;


  case 42: /* exp: exp NOT_EQUAL exp  */
  if (yyn == 42)
    /* "./parser/pythonparser.y":287  */
                    {
				yyval=new InfixExpression(((Expression)(yystack.valueAt (2))),"!=",((Expression)(yystack.valueAt (0))));
                };
  break;


  case 43: /* exp: exp NOT_EQUAL_2 exp  */
  if (yyn == 43)
    /* "./parser/pythonparser.y":290  */
                      {
				yyval=new InfixExpression(((Expression)(yystack.valueAt (2))),"!=",((Expression)(yystack.valueAt (0))));
                };
  break;


  case 44: /* exp: NOT exp  */
  if (yyn == 44)
    /* "./parser/pythonparser.y":293  */
          {
	yyval=new PrefixExpression("!",((Expression)(yystack.valueAt (0))));
};
  break;


  case 45: /* exp: exp GREATER_THAN_OR_EQUAL exp  */
  if (yyn == 45)
    /* "./parser/pythonparser.y":296  */
                                {
	yyval=new InfixExpression(((Expression)(yystack.valueAt (2))),">=",((Expression)(yystack.valueAt (0))));
};
  break;


  case 46: /* exp: exp LESS_THAN_OR_EQUAL exp  */
  if (yyn == 46)
    /* "./parser/pythonparser.y":299  */
                             {
	yyval=new InfixExpression(((Expression)(yystack.valueAt (2))),"<=",((Expression)(yystack.valueAt (0))));
};
  break;


  case 47: /* exp: exp '<' exp  */
  if (yyn == 47)
    /* "./parser/pythonparser.y":302  */
              {
	yyval=new InfixExpression(((Expression)(yystack.valueAt (2))),"<",((Expression)(yystack.valueAt (0))));
};
  break;


  case 48: /* exp: exp '>' exp  */
  if (yyn == 48)
    /* "./parser/pythonparser.y":305  */
              {
	yyval=new InfixExpression(((Expression)(yystack.valueAt (2))),">",((Expression)(yystack.valueAt (0))));
};
  break;


  case 49: /* exp: exp '+' exp  */
  if (yyn == 49)
    /* "./parser/pythonparser.y":308  */
              {
	yyval=new InfixExpression(((Expression)(yystack.valueAt (2))),"+",((Expression)(yystack.valueAt (0)))); // An AST node for binary ops
};
  break;


  case 50: /* exp: exp '-' exp  */
  if (yyn == 50)
    /* "./parser/pythonparser.y":311  */
              {
	yyval=new InfixExpression(((Expression)(yystack.valueAt (2))),"-",((Expression)(yystack.valueAt (0)))); // An AST node for binary ops
};
  break;


  case 51: /* exp: exp '*' exp  */
  if (yyn == 51)
    /* "./parser/pythonparser.y":314  */
              {
	yyval=new InfixExpression(((Expression)(yystack.valueAt (2))),"*",((Expression)(yystack.valueAt (0)))); // An AST node for binary ops
};
  break;


  case 52: /* exp: exp '/' exp  */
  if (yyn == 52)
    /* "./parser/pythonparser.y":317  */
              {
	yyval=new InfixExpression(((Expression)(yystack.valueAt (2))),"/",((Expression)(yystack.valueAt (0)))); // An AST node for binary ops
};
  break;


  case 53: /* exp: exp '%' exp  */
  if (yyn == 53)
    /* "./parser/pythonparser.y":320  */
             {
	yyval=new InfixExpression(((Expression)(yystack.valueAt (2))),"%",((Expression)(yystack.valueAt (0))));
};
  break;


  case 54: /* exp: '-' exp  */
  if (yyn == 54)
    /* "./parser/pythonparser.y":323  */
                    {
	yyval=new InfixExpression(new Literal(0.0),"-",((Expression)(yystack.valueAt (0)))); // An AST node for binary ops
};
  break;


  case 55: /* exp: exp POWER exp  */
  if (yyn == 55)
    /* "./parser/pythonparser.y":326  */
                {
	yyval=new InfixExpression(((Expression)(yystack.valueAt (2))),"**",((Expression)(yystack.valueAt (0))));
};
  break;


  case 56: /* exp: exp FLOOR_DIVISION exp  */
  if (yyn == 56)
    /* "./parser/pythonparser.y":329  */
                        {
	yyval=new InfixExpression(((Expression)(yystack.valueAt (2))),"//",((Expression)(yystack.valueAt (0))));
};
  break;


  case 57: /* exp: '(' exp ')'  */
  if (yyn == 57)
    /* "./parser/pythonparser.y":332  */
              {
	yyval=((Expression)(yystack.valueAt (1)));
};
  break;


  case 58: /* exp: IDENTIFIER '[' exp ']'  */
  if (yyn == 58)
    /* "./parser/pythonparser.y":335  */
                         {
	yyval=new IndexExpression(((Identifier)(yystack.valueAt (3))),((Expression)(yystack.valueAt (1))));
};
  break;


  case 59: /* exp: IDENTIFIER '=' exp  */
  if (yyn == 59)
    /* "./parser/pythonparser.y":338  */
                     {
	yyval=new AssignmentExpression(((Identifier)(yystack.valueAt (2))),((Expression)(yystack.valueAt (0))),null); //Adds a new symbol to the context
};
  break;


  case 60: /* exp: IDENTIFIER '[' exp ']' '=' exp  */
  if (yyn == 60)
    /* "./parser/pythonparser.y":341  */
                                {
	yyval=new AssignmentExpression(((Identifier)(yystack.valueAt (5))),((Expression)(yystack.valueAt (0))),((Expression)(yystack.valueAt (3)))); //Assign a list element to a new value
};
  break;


  case 61: /* exp: IDENTIFIER '(' exp_list ')'  */
  if (yyn == 61)
    /* "./parser/pythonparser.y":344  */
                              {
	//Define a function call using the identifier and the parameters list
	yyval=new FunctionCall(((Identifier)(yystack.valueAt (3))),((List<Expression>)(yystack.valueAt (1))));
};
  break;


  case 62: /* exp: IDENTIFIER '(' ')'  */
  if (yyn == 62)
    /* "./parser/pythonparser.y":348  */
                    {
	//Define a function call using the identifier
    yyval=new FunctionCall(((Identifier)(yystack.valueAt (2))),new ArrayList<Expression>());
};
  break;


  case 63: /* exp_list: exp  */
  if (yyn == 63)
    /* "./parser/pythonparser.y":357  */
    {yyval= new ArrayList<>(List.of(((Expression)(yystack.valueAt (0)))));};
  break;


  case 64: /* exp_list: exp ',' exp_list  */
  if (yyn == 64)
    /* "./parser/pythonparser.y":358  */
                   {
	yyval=new ArrayList<>(List.of(((Expression)(yystack.valueAt (2)))));
	((List)(yyval)).addAll(((List<Expression>)(yystack.valueAt (0)))); //Combine all expressions together
};
  break;


  case 65: /* if_pred: exp  */
  if (yyn == 65)
    /* "./parser/pythonparser.y":365  */
    {
//$$=(Boolean)$1;
};
  break;



/* "./src/main/java/io/codeberg/jkpython/compiler/parser/Parser.java":1262  */

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

  private static final short yypact_ninf_ = -54;
  private static final byte yytable_ninf_ = -1;

/* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
   STATE-NUM.  */
  private static final short[] yypact_ = yypact_init();
  private static final short[] yypact_init()
  {
    return new short[]
    {
      72,   -54,   -54,   -54,   -53,   -54,   -54,    99,   -54,   -54,
     142,   -25,   142,   -23,   142,   -54,   142,   -54,   142,    29,
      10,   -54,    72,   -54,   -54,   -54,   -54,   -54,   292,   142,
     140,   142,   -54,   351,   438,   -49,   417,   -50,   -19,   206,
       6,   281,   -54,   360,   -46,   -54,   -54,   142,   142,   142,
     142,   142,   142,   142,   142,   142,   142,   142,   142,   142,
     142,   142,   142,   -54,   417,   -54,   -42,   184,   -54,   -29,
     -39,   142,   -39,   -54,   142,   -54,   447,   447,   447,   447,
     447,     6,     6,   438,   425,   447,   447,    89,    89,     6,
       6,     6,   -54,   -28,   -26,   -37,   -40,    30,   -33,   268,
     -54,   -54,   142,     3,   -39,   -32,    72,   -31,   142,     8,
     -39,   417,   -54,   -54,   -39,    54,   -39,    -8,    -4,   -54,
     -54,   -54,   -54,   -39,   -39,    13,   -54,   -54
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
       2,    34,    36,    35,    30,    13,    33,     0,    32,    31,
       0,     0,     0,     0,     0,    14,     0,     6,     0,     0,
       0,     3,     4,    11,     9,    10,    12,     8,     0,     0,
       0,     0,    21,     0,    44,     0,    65,     0,     0,     0,
      54,     0,    38,    63,     0,     1,     5,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,     0,     7,    59,    62,     0,     0,    22,     0,
       0,     0,     0,    57,     0,    37,    46,    45,    41,    42,
      43,    55,    56,    39,    40,    47,    48,    49,    50,    51,
      52,    53,    61,    58,    17,     0,     0,     0,    23,     0,
      20,    64,     0,     0,     0,     0,     0,     0,     0,    25,
       0,    60,    18,    16,     0,     0,     0,     0,     0,    19,
      15,    29,    24,     0,     0,    27,    26,    28
    };
  }

/* YYPGOTO[NTERM-NUM].  */
  private static final byte[] yypgoto_ = yypgoto_init();
  private static final byte[] yypgoto_init()
  {
    return new byte[]
    {
     -54,   -54,   -21,   -54,   -54,   -35,   -54,   -54,   -54,   -54,
     -48,   -41,    -7,   -17,   -36
    };
  }

/* YYDEFGOTO[NTERM-NUM].  */
  private static final byte[] yydefgoto_ = yydefgoto_init();
  private static final byte[] yydefgoto_init()
  {
    return new byte[]
    {
       0,    20,    21,    22,    23,    96,    24,    25,    26,    27,
     109,    98,    28,    44,    37
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
      33,    46,    94,    34,    29,    36,    35,    39,    38,    40,
      45,    41,    43,    66,    30,   107,   108,    31,    69,    70,
      71,    52,    64,    43,    67,    75,    92,    97,   105,   102,
     103,   100,   104,   106,    94,     1,     2,   114,   116,    95,
      76,    77,    78,    79,    80,    81,    82,    83,    84,    85,
      86,    87,    88,    89,    90,    91,   118,   101,   121,     3,
       4,   123,   108,   113,    99,   124,     6,    43,   112,   119,
       8,     9,   117,   120,    10,   122,     0,   127,     1,     2,
       0,     0,   125,   126,     0,   115,     0,     0,     0,     0,
      16,     0,     0,     0,     0,   111,    18,     0,     0,    19,
      42,    36,     3,     4,    52,     1,     2,     0,     5,     6,
       0,     0,     7,     8,     9,     0,    53,    10,    11,    12,
       0,     0,    13,    14,    15,     0,     0,     0,     0,     3,
       4,     0,     0,    16,     0,     0,     6,     0,    17,    18,
       8,     9,    19,     0,    10,     0,     1,     2,     1,     2,
       0,    60,    61,    62,     0,     0,     0,     0,     0,     0,
      16,     0,     0,     0,     0,    32,    18,     0,     0,    19,
       3,     4,     3,     4,     0,     0,     0,     6,     0,     6,
       0,     8,     9,     8,     9,    10,     0,    10,     0,     0,
       0,     0,    47,    48,    49,    50,    51,     0,     0,    52,
       0,    16,     0,    16,     0,     0,     0,    18,    65,    18,
      19,    53,    19,     0,    47,    48,    49,    50,    51,     0,
       0,    52,     0,     0,     0,     0,     0,    54,    55,     0,
       0,     0,     0,    53,     0,     0,     0,     0,     0,     0,
       0,     0,    56,    57,    58,    59,    60,    61,    62,    54,
      55,     0,     0,     0,     0,    93,     0,     0,     0,     0,
       0,     0,     0,     0,    56,    57,    58,    59,    60,    61,
      62,     0,     0,     0,     0,    72,    47,    48,    49,    50,
      51,     0,     0,    52,     0,     0,     0,     0,     0,    47,
      48,    49,    50,    51,     0,    53,    52,     0,     0,     0,
      47,    48,    49,    50,    51,     0,     0,    52,    53,     0,
       0,    54,    55,     0,     0,     0,     0,     0,     0,    53,
       0,     0,     0,     0,    54,    55,    56,    57,    58,    59,
      60,    61,    62,     0,     0,    54,    55,   110,     0,    56,
      57,    58,    59,    60,    61,    62,     0,     0,     0,    73,
      56,    57,    58,    59,    60,    61,    62,     0,    63,    47,
      48,    49,    50,    51,     0,     0,    52,     0,    47,    48,
      49,    50,    51,     0,     0,    52,     0,     0,    53,     0,
       0,     0,     0,     0,     0,     0,     0,    53,     0,     0,
       0,     0,     0,     0,    54,    55,     0,     0,     0,     0,
       0,     0,     0,    54,    55,     0,     0,     0,     0,    56,
      57,    58,    59,    60,    61,    62,    74,    68,    56,    57,
      58,    59,    60,    61,    62,    47,    48,    49,    50,    51,
       0,     0,    52,    47,    48,    49,    50,    51,     0,     0,
      52,     0,     0,     0,    53,     0,    47,    48,    49,    50,
      51,     0,    53,    52,     0,    -1,    -1,    -1,    -1,    -1,
      54,    55,    52,     0,     0,    53,     0,     0,    54,     0,
       0,     0,     0,     0,    53,    56,    57,    58,    59,    60,
      61,    62,     0,    56,    57,    58,    59,    60,    61,    62,
       0,     0,     0,     0,     0,     0,    56,    57,    58,    59,
      60,    61,    62,     0,     0,    -1,    -1,    58,    59,    60,
      61,    62
    };
  }

private static final byte[] yycheck_ = yycheck_init();
  private static final byte[] yycheck_init()
  {
    return new byte[]
    {
       7,    22,    31,    10,    57,    12,    31,    14,    31,    16,
       0,    18,    19,    30,    67,    48,    49,    70,    67,    69,
      39,    15,    29,    30,    31,    71,    68,    66,    68,    57,
      56,    72,    69,     3,    31,     6,     7,    69,    69,    68,
      47,    48,    49,    50,    51,    52,    53,    54,    55,    56,
      57,    58,    59,    60,    61,    62,    48,    74,     4,    30,
      31,    69,    49,   104,    71,    69,    37,    74,   103,   110,
      41,    42,   108,   114,    45,   116,    -1,   125,     6,     7,
      -1,    -1,   123,   124,    -1,   106,    -1,    -1,    -1,    -1,
      61,    -1,    -1,    -1,    -1,   102,    67,    -1,    -1,    70,
      71,   108,    30,    31,    15,     6,     7,    -1,    36,    37,
      -1,    -1,    40,    41,    42,    -1,    27,    45,    46,    47,
      -1,    -1,    50,    51,    52,    -1,    -1,    -1,    -1,    30,
      31,    -1,    -1,    61,    -1,    -1,    37,    -1,    66,    67,
      41,    42,    70,    -1,    45,    -1,     6,     7,     6,     7,
      -1,    62,    63,    64,    -1,    -1,    -1,    -1,    -1,    -1,
      61,    -1,    -1,    -1,    -1,    66,    67,    -1,    -1,    70,
      30,    31,    30,    31,    -1,    -1,    -1,    37,    -1,    37,
      -1,    41,    42,    41,    42,    45,    -1,    45,    -1,    -1,
      -1,    -1,     8,     9,    10,    11,    12,    -1,    -1,    15,
      -1,    61,    -1,    61,    -1,    -1,    -1,    67,    68,    67,
      70,    27,    70,    -1,     8,     9,    10,    11,    12,    -1,
      -1,    15,    -1,    -1,    -1,    -1,    -1,    43,    44,    -1,
      -1,    -1,    -1,    27,    -1,    -1,    -1,    -1,    -1,    -1,
      -1,    -1,    58,    59,    60,    61,    62,    63,    64,    43,
      44,    -1,    -1,    -1,    -1,    71,    -1,    -1,    -1,    -1,
      -1,    -1,    -1,    -1,    58,    59,    60,    61,    62,    63,
      64,    -1,    -1,    -1,    -1,    69,     8,     9,    10,    11,
      12,    -1,    -1,    15,    -1,    -1,    -1,    -1,    -1,     8,
       9,    10,    11,    12,    -1,    27,    15,    -1,    -1,    -1,
       8,     9,    10,    11,    12,    -1,    -1,    15,    27,    -1,
      -1,    43,    44,    -1,    -1,    -1,    -1,    -1,    -1,    27,
      -1,    -1,    -1,    -1,    43,    44,    58,    59,    60,    61,
      62,    63,    64,    -1,    -1,    43,    44,    69,    -1,    58,
      59,    60,    61,    62,    63,    64,    -1,    -1,    -1,    68,
      58,    59,    60,    61,    62,    63,    64,    -1,    66,     8,
       9,    10,    11,    12,    -1,    -1,    15,    -1,     8,     9,
      10,    11,    12,    -1,    -1,    15,    -1,    -1,    27,    -1,
      -1,    -1,    -1,    -1,    -1,    -1,    -1,    27,    -1,    -1,
      -1,    -1,    -1,    -1,    43,    44,    -1,    -1,    -1,    -1,
      -1,    -1,    -1,    43,    44,    -1,    -1,    -1,    -1,    58,
      59,    60,    61,    62,    63,    64,    56,    66,    58,    59,
      60,    61,    62,    63,    64,     8,     9,    10,    11,    12,
      -1,    -1,    15,     8,     9,    10,    11,    12,    -1,    -1,
      15,    -1,    -1,    -1,    27,    -1,     8,     9,    10,    11,
      12,    -1,    27,    15,    -1,     8,     9,    10,    11,    12,
      43,    44,    15,    -1,    -1,    27,    -1,    -1,    43,    -1,
      -1,    -1,    -1,    -1,    27,    58,    59,    60,    61,    62,
      63,    64,    -1,    58,    59,    60,    61,    62,    63,    64,
      -1,    -1,    -1,    -1,    -1,    -1,    58,    59,    60,    61,
      62,    63,    64,    -1,    -1,    58,    59,    60,    61,    62,
      63,    64
    };
  }

/* YYSTOS[STATE-NUM] -- The symbol kind of the accessing symbol of
   state STATE-NUM.  */
  private static final byte[] yystos_ = yystos_init();
  private static final byte[] yystos_init()
  {
    return new byte[]
    {
       0,     6,     7,    30,    31,    36,    37,    40,    41,    42,
      45,    46,    47,    50,    51,    52,    61,    66,    67,    70,
      73,    74,    75,    76,    78,    79,    80,    81,    84,    57,
      67,    70,    66,    84,    84,    31,    84,    86,    31,    84,
      84,    84,    71,    84,    85,     0,    74,     8,     9,    10,
      11,    12,    15,    27,    43,    44,    58,    59,    60,    61,
      62,    63,    64,    66,    84,    68,    85,    84,    66,    67,
      69,    39,    69,    68,    56,    71,    84,    84,    84,    84,
      84,    84,    84,    84,    84,    84,    84,    84,    84,    84,
      84,    84,    68,    71,    31,    68,    77,    66,    83,    84,
      83,    85,    57,    56,    69,    68,     3,    48,    49,    82,
      69,    84,    77,    83,    69,    74,    69,    86,    48,    83,
      83,     4,    83,    69,    69,    83,    83,    82
    };
  }

/* YYR1[RULE-NUM] -- Symbol kind of the left-hand side of rule RULE-NUM.  */
  private static final byte[] yyr1_ = yyr1_init();
  private static final byte[] yyr1_init()
  {
    return new byte[]
    {
       0,    72,    73,    73,    74,    74,    75,    75,    75,    75,
      75,    75,    75,    75,    75,    76,    76,    77,    77,    78,
      79,    80,    80,    81,    81,    81,    81,    82,    82,    83,
      84,    84,    84,    84,    84,    84,    84,    84,    84,    84,
      84,    84,    84,    84,    84,    84,    84,    84,    84,    84,
      84,    84,    84,    84,    84,    84,    84,    84,    84,    84,
      84,    84,    84,    85,    85,    86
    };
  }

/* YYR2[RULE-NUM] -- Number of symbols on the right-hand side of rule RULE-NUM.  */
  private static final byte[] yyr2_ = yyr2_init();
  private static final byte[] yyr2_init()
  {
    return new byte[]
    {
       0,     2,     0,     1,     1,     2,     1,     2,     1,     1,
       1,     1,     1,     1,     1,     7,     6,     1,     3,     6,
       4,     2,     3,     4,     7,     5,     8,     4,     5,     4,
       1,     1,     1,     1,     1,     1,     1,     3,     2,     3,
       3,     3,     3,     3,     2,     3,     3,     3,     3,     3,
       3,     3,     3,     3,     2,     3,     3,     3,     4,     3,
       6,     4,     3,     1,     3,     1
    };
  }




  /* YYTRANSLATE_(TOKEN-NUM) -- Symbol number corresponding to TOKEN-NUM
     as returned by yylex, with out-of-bounds checking.  */
  private static final SymbolKind yytranslate_(int t)
  {
    // Last valid token kind.
    int code_max = 311;
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
      66,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,    64,     2,     2,
      67,    68,    62,    60,    56,    61,     2,    63,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,    69,     2,
      58,    57,    59,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,    70,     2,    71,     2,     2,     2,     2,     2,     2,
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
      55,    65
    };
  }


  private static final int YYLAST_ = 511;
  private static final int YYEMPTY_ = -2;
  private static final int YYFINAL_ = 45;
  private static final int YYNTOKENS_ = 72;

/* Unqualified %code blocks.  */
/* "./parser/pythonparser.y":24  */

	public Program program;

/* "./src/main/java/io/codeberg/jkpython/compiler/parser/Parser.java":1932  */

}
/* "./parser/pythonparser.y":369  */

