//
//  Transpiler.hpp
//  codewars
//
//  Created by Evelyn on 2020/2/26.
//  Copyright © 2020 Evelyn. All rights reserved.
//

#ifndef Transpiler_hpp
#define Transpiler_hpp

#include <stdio.h>
#include <iostream>

using namespace std;


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
    EMPTY, // \n
    END
};

class Token {
public:
    token_type type;
    string value;
    
    Token(){};
    Token(token_type, string);
};

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
    void advance();
    void backward();
    
    void retreat(Token token);
    
private:
    

    
    void skip_blank();
    bool is_number();
    int next_number();
    
    bool is_letter();
    bool is_underline();

    string next_name();
    
    string arrow();
};

class Transpiler {
public:
    Lexer lexer;
    string input;
    
    Token current_token;
    
    bool eat(token_type);
    
    const char* function();
    string name_or_number();
    string expression();
    string parameters();
    string lambda_param();
    string lambda_stmt();
    string lambda();
    
    Transpiler(string);
    
};
#endif /* Transpiler_hpp */
