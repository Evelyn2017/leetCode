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
    NAME,  //_a1, a1, aaa_a
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

class Lexer {
public:
    string line;
    int index;
    char current;
    
    Lexer(string);
    
    Token get_next_token();
    Token peek();
    
    void error();

private:
    Lexer(){};
    
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
    while (this->index < this->line.length() && this->current == ' ')
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
        
        if (current == '_') {
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
    return Token(END, NULL);
}

Token Lexer:: peek() {
    Token t = get_next_token();
    retreat(t);
    return t;
}

void Lexer:: error() {
    cout << "lexical error in " << index << " ." <<endl;
}

class Function {
    
};

class Expression {
    
};

class Parameters {
    
};

class LambdaParam {
    
};

class lambdaStmt {
    
};

class Lambda {
    
};



string transpiler (string expression) {
    return "";
}
