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
#include "../include/Transpiler.hpp"

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


////////////////Token///////////////////////
Token:: Token(token_type type, string value) {
    this->type = type;
    this->value = value;
}




////////////////////Lexer//////////////////
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
    while (this->index < this->line.length()  && (this->current == ' ' || current == '\n'))
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
        if (current == '>') {
            advance();
            return "->";
        }
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
        
//        if (current = '\n')
//        {
//            advance();
//            continue;
//        }
        advance();
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


////////////////////////Transpiler///////////////////////////
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
//        cout<<"error at " << this->lexer.index<<endl;
    return false;
}


// fun(a) {} ==> fun(a, (){})
// fun (a, {}) == fun(a){}
//{}()
// fun{} ==> fun()
// fun{a->a}
//expression "(" [parameters] ")" [lambda] | expression lambda  ====> expression "(" [parameters] ")"
const char* Transpiler:: function() {
    string expr = expression();
    string para;
    string lam;
    if (eat(LPAREN) == true) {
        para = parameters();
        if (!eat(RPAREN)) {
            lam = lambda();
            if (lam == "")
                return "";
            return (expr + "(" + para + lam + ")").c_str();
        }
        else {
            lam = lambda();
        }
    }
    else {
        lam = lambda();
        if (lam == "")
            return "";
    }
    
    if (lam != "" && para != "") {
        return (expr + "(" + para + "," + lam + ")").c_str();
    }
    else {
        string tmp = expr + "(" + para + lam + ")";
        return tmp.c_str();
    }
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
    if (expr != "")
        return expr;
    
    string lamb = lambda();
    if (lamb != "")
        return lamb;
    return "";
}

// a,b
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
    string name_number = name_or_number();
    if (name_number == "")
        return "";
    if (eat(COMMA) == true) {
        name_number += ",";
        string param = lambda_param();
        if (param == "")
            return "";
        else
            return name_number + param;
    }
    return name_number;
}

// lambdastmt  ::= nameOrNumber [lambdastmt]  =====>  lambdastmt  ::= nameOrNumber ";" [lambdastmt]
string Transpiler:: lambda_stmt() {
    string name_number = name_or_number();
    if (name_number == "")
        return "";
    string stmt = lambda_stmt();
    name_number += ";";
    return name_number + stmt;
}


// {}()
// {a} ==> (){a;}
// {a->a} ==> (a){a;}
// fun() ==> fun()
// lambda ::= "{" [lambdaparam "->"] [lambdastmt] "}"   =====>  lambda ::= "(" [lambdaparam] "){" [lambdastmt] "}"
string Transpiler:: lambda() {
    string param;
    string stmt;
    if (eat(LBRACE)) {
        param = lambda_param();
        if (param != "") {
            if (eat(ARROW)) {
                param = "(" + param + ")";
                stmt = "{" + lambda_stmt() + "}";
            }
            else {
                stmt = "{" + param + ";}";
                param = "()"; 
            }
            
        }
        else {
            param = "(" + param + ")";
            stmt = "{" + lambda_stmt() + "}";
        }
        if (!eat(RBRACE))
            return "";
    }
    return param  + stmt;
}




