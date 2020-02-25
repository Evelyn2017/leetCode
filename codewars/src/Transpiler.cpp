//
//  Transpiler.cpp
//  codewars
//
//  Created by Evelyn on 2020/2/24.
//  Copyright © 2020 Evelyn. All rights reserved.
//

// names, like abc, ABC, run, a1, beginning with _/letters and followed by _/letters/numbers
// numbers, like 123, 2333, 66666
// lambda expressions, like { a -> a }, { a, b -> a b }(source), (a){a;}, (a,b){a;b;}(target)

#include <iostream>
using namespace std;

//char *cat (const char *s0, ...);              // cat all strings together, stop at argument value 0
//char *segment (const char *s, const char *e); // create string from characters between s (inclusive) and e (exclusive)
//
//struct list;
//
//list *node (void *data);           // create one-element list
//list *concat (list *l1, list *l2); // concatenate two lists, modifies l1
//
//const char *transpile (const char* expression) {
//    return "";
//}

enum token_type {
    NUMBER, // 123
    NAME,  //_a1, a1, aaa___11111a
    LBRACE, // {
    RBRACE, // }
    LPAREN, // (
    RPAREN, // )
    ARROW, // ->
    COMMA, // ,
    SEMICOLON, // ;
    END
};

class Token {
public:
    token_type type;
    string value;
    
    Token(){};
    Token(token_type type, string value){
        this->type = type;
        this->value = value;
    };
};


std:: ostream& operator << (std::ostream &strm, const Token& token) {
    return strm<<"Token <"<<token.type << ", "<<token.value<<">"<<endl;
}

class Lexer {
public:
    string line;
    int index;
    char current;
    
    Lexer(string);
    Lexer(){};
    
    Token get_next_token();
    Token peek();
    
    void error();

private:
    
    void advance();
    void backward();
    
    void retreat(Token token);
    
    void skip_blank();
    bool is_number();
    int next_number();
    
    bool is_letter();
    bool is_underline();
    string next_name();
    
    string arrow();
};

Lexer:: Lexer(string line) {
    this->line = line;
    this->index = 0;
    this->current = line[this->index];
}

void Lexer:: advance() {
    this->index ++;
    if(this->index > this->line.length() - 1)
        this->current = NULL;
    else
        this->current = this->line[this->index];
}

void Lexer:: backward() {
    this->index --;
    if (index < 0)
        current = NULL;
    else
        current = line[index];
}

void Lexer:: retreat(Token token) {
    for(int i = 0; i < token.value.length(); i++)
        this->index --;
    this->current = this->line[this->index];
}

void Lexer:: skip_blank() {
    while (this->index < this->line.length()  && this->current == ' ')
        this->advance();
}

bool Lexer:: is_number() {
    if (this->current <= '9' && this->current >= '0')
        return true;
    return false;
}

int Lexer:: next_number (){
    string res;
    while (this->index < this->line.length() && is_number()) {
        res += current;
        advance();
    }
    return atoi(res.c_str());
}

bool Lexer:: is_letter() {
    if ((current <= 'Z' && current >= 'A') || (current <= 'z' && current >= 'a'))
        return true;
    return false;
}

bool Lexer:: is_underline() {
    if (current == '_')
        return true;
    return false;
}


// beginning with _/letters and followed by _/letters/numbers
string Lexer:: next_name() {
    string res = "";
    if (is_underline() || is_letter()) {
        res += current;
        advance();
    }
    while (index < line.length() && (is_letter() || is_underline() || is_number())) {
        res += current;
        advance();
    }
    return res;
}

string Lexer:: arrow() {
    if (current == '-') {
        advance();
        if (current == '>')
            return "->";
        // TODO: not sure to backward
        else {
            backward();
            return "";
        }
    }
    return "";
}

Token Lexer:: get_next_token() {
    while (index < line.length()) {
        if (current == ' ') {
            skip_blank();
            continue;
        }
        
        if (is_number()) {
            return Token(NUMBER, std::to_string(next_number()));
        }
        
        if (current == '_' || is_letter()) {
            return Token(NAME, next_name());
        }
        
        if (current == '-') {
            return Token(ARROW, arrow());
        }
        
        if (current == '(') {
            advance();
            return Token(LPAREN, "(");
        }
        
        if (current == ')') {
            advance();
            return Token(RPAREN, ")");
        }
        
        if (current == '{') {
            advance();
            return Token(LBRACE, "{");
        }
        
        if (current == '}') {
            advance();
            return Token(RBRACE, "}");
        }
        
        if (current == ',') {
            advance();
            return Token(COMMA, ",");
        }
        
        if (current == ';') {
            advance();
            return Token(SEMICOLON, ";");
        }
        
        error();
    }
    return Token(END,"end");
}

Token Lexer:: peek() {
    Token t = get_next_token();
    retreat(t);
    return t;
}

void Lexer:: error() {
    cout << "lexical error in " << index << " ." <<endl;
}


class Transpiler {
public:
    Lexer lexer;
    string input;
    
    Token current_token;
    
    bool eat(token_type);
    
    string function();
    string name_or_number();
    string expression();
    string parameters();
    string lambda_param();
    string lambda_stmt();
    string lambda();
    
    Transpiler(string);
    
};

Transpiler:: Transpiler(string input) {
    this->input = input;
    this->lexer = Lexer(this->input);
    this->current_token = lexer.get_next_token();
}

bool Transpiler:: eat(token_type type) {
    if (type == current_token.type) {
        current_token = lexer.get_next_token();
        return true;
    }
//    else
//        cout<<"error at " << current_token<<endl;
    return false;
}

//function ::= expression "(" [parameters] ")" [lambda] | expression lambda   =====>   function ::= expression "(" [parameters] ")"
string Transpiler:: function() {
    return "";
}

string Transpiler:: name_or_number() {
    string res;
    if (current_token.type == NAME || current_token.type == NUMBER) {
        token_type t = current_token.type == NAME ? NAME : NUMBER;
        res = current_token.value;
        eat(t);
        return res;
    }
    return "";
}

// expression ::= nameOrNumber | lambda  ====>  expression ::= nameOrNumber | lambda
string Transpiler:: expression() {
    string expr = name_or_number();
    
    if (expr == "")
        expr = lambda();
    
    return expr;
}

// parameters ::= expression ["," parameters]  ====>  parameters ::= expression ["," parameters]
string Transpiler:: parameters() {
    string expr = expression();
    if (expr == "")
        return "";
    while (eat(COMMA) == true) {
        expr += ",";
        if (current_token.type == NAME || current_token.type == NUMBER) {
            expr += current_token.value;
            eat(current_token.type == NAME ? NAME : NUMBER);
        }
    }
    return expr;
}

// lambdaparam ::= nameOrNumber ["," lambdaparam]  =====>  lambdaparam ::= nameOrNumber ["," lambdaparam]
string Transpiler:: lambda_param() {
    string res;
    if (current_token.type == NAME || current_token.type == NUMBER) {
        token_type t = current_token.type == NAME ? NAME : NUMBER;
        res = current_token.value;
        eat(t);
    }
    
    while (eat(COMMA) == true) {
        
    }
    
    return "";
}

// lambdastmt  ::= nameOrNumber [lambdastmt]  =====>  lambdastmt  ::= nameOrNumber ";" [lambdastmt]
string Transpiler:: lambda_stmt() {
    return "";
}

// lambda ::= "{" [lambdaparam "->"] [lambdastmt] "}"   =====>  lambda ::= "{" [lambdaparam "->"] [lambdastmt] "}"
string Transpiler:: lambda() {
    return "";
}

string transpiler (string expression) {
    return "";
}

void token_type_cheat_sheet() {
    cout<<"-----------------------------------------------------------"<<endl;
    cout<<NUMBER << "        "<<NAME <<"      "<<LBRACE <<"      "<<RBRACE <<"       "<<LPAREN<<"     "<<RPAREN <<"      " <<ARROW << "     " <<COMMA <<"     "<<SEMICOLON<<endl;
    cout<<"NUMBER   "<<"NAME   "<<"{ "<<"     }" << "       ("<<"     )"<<"      -> "<<"   ,"<<"     ;"<<endl;
    cout<<"-----------------------------------------------------------"<<endl;
}


// fun() => fun()
// fun(a) => fun(a)
// fun(a, b) => fun(a,b)
// {}() => (){}()
// fun {} => fun((){})
// fun(a, {}) => fun(a,(){})
// fun(a) {} => fun(a,(){})
// fun {a -> a} => fun((a){a;})
// {a -> a}(1) => (a){a;}(1)
// fun { a, b -> a b } => fun((a,b){a;b;})
// {a, b -> a b} (1, 2) => (a,b){a;b;}(1,2)
// f { a } => f((){a;})
// f { a -> } => f((a){})
int main() {
    token_type_cheat_sheet();
//    string line = "_a_1, b_1, c1_";
//    Transpiler t = Transpiler(line);
//    cout<<t.parameters()<<endl;
    
    return 0;
}
