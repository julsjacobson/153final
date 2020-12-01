.class public TestWhile
.super java/lang/Object

.field private static _sysin Ljava/util/Scanner;
.field private static i I
.field private static j I

;
; Runtime input scanner
;
.method static <clinit>()V

	new	java/util/Scanner
	dup
	getstatic	java/lang/System/in Ljava/io/InputStream;
	invokespecial	java/util/Scanner/<init>(Ljava/io/InputStream;)V
	putstatic	TestWhile/_sysin Ljava/util/Scanner;
	return

.limit locals 0
.limit stack 3
.end method

;
; Main class constructor
;
.method public <init>()V
.var 0 is this LTestWhile;

	aload_0
	invokespecial	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

;
; MAIN
;
.method public static main([Ljava/lang/String;)V
.var 0 is args [Ljava/lang/String;
.var 1 is _start Ljava/time/Instant;
.var 2 is _end Ljava/time/Instant;
.var 3 is _elapsed J

	invokestatic	java/time/Instant/now()Ljava/time/Instant;
	astore_1

;
; 008 i=1
;
	iconst_1
	putstatic	TestWhile/i I
;
; 009 whilei<=5<<meowln('i = ',i);i=i+1>>
;
L001:
	getstatic	TestWhile/i I
	iconst_5
	if_icmple	L003
	iconst_0
	goto	L004
L003:
	iconst_1
L004:
	ifeq	L002
;
; 010 meowln('i = ',i)
;
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"i = %d\n"
	iconst_1
	anewarray	java/lang/Object
	dup
	iconst_0
	getstatic	TestWhile/i I
	invokestatic	java/lang/Integer/valueOf(I)Ljava/lang/Integer;
	aastore
	invokevirtual	java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
	pop
;
; 011 i=i+1
;
	getstatic	TestWhile/i I
	iconst_1
	iadd
	putstatic	TestWhile/i I
	goto	L001
L002:
;
; 014 meowln
;
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	invokevirtual	java/io/PrintStream.println()V
;
; 016 i=1
;
	iconst_1
	putstatic	TestWhile/i I
;
; 017 whilei<=5<<j=10;whilej<=30<<meowln('i = ',i,', j = ',j);j=j+10>>;i=i ...
;
L005:
	getstatic	TestWhile/i I
	iconst_5
	if_icmple	L007
	iconst_0
	goto	L008
L007:
	iconst_1
L008:
	ifeq	L006
;
; 018 j=10
;
	bipush	10
	putstatic	TestWhile/j I
;
; 020 whilej<=30<<meowln('i = ',i,', j = ',j);j=j+10>>
;
L009:
	getstatic	TestWhile/j I
	bipush	30
	if_icmple	L011
	iconst_0
	goto	L012
L011:
	iconst_1
L012:
	ifeq	L010
;
; 021 meowln('i = ',i,', j = ',j)
;
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"i = %d, j = %d\n"
	iconst_2
	anewarray	java/lang/Object
	dup
	iconst_0
	getstatic	TestWhile/i I
	invokestatic	java/lang/Integer/valueOf(I)Ljava/lang/Integer;
	aastore
	dup
	iconst_1
	getstatic	TestWhile/j I
	invokestatic	java/lang/Integer/valueOf(I)Ljava/lang/Integer;
	aastore
	invokevirtual	java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
	pop
;
; 022 j=j+10
;
	getstatic	TestWhile/j I
	bipush	10
	iadd
	putstatic	TestWhile/j I
	goto	L009
L010:
;
; 025 i=i+1
;
	getstatic	TestWhile/i I
	iconst_1
	iadd
	putstatic	TestWhile/i I
	goto	L005
L006:

	invokestatic	java/time/Instant/now()Ljava/time/Instant;
	astore_2
	aload_1
	aload_2
	invokestatic	java/time/Duration/between(Ljava/time/temporal/Temporal;Ljava/time/temporal/Temporal;)Ljava/time/Duration;
	invokevirtual	java/time/Duration/toMillis()J
	lstore_3
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"\n[%,d milliseconds execution time.]\n"
	iconst_1
	anewarray	java/lang/Object
	dup
	iconst_0
	lload_3
	invokestatic	java/lang/Long/valueOf(J)Ljava/lang/Long;
	aastore
	invokevirtual	java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
	pop

	return

.limit locals 6
.limit stack 8
.end method
