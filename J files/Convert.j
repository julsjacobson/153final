.class public Convert
.super java/lang/Object

.field private static _sysin Ljava/util/Scanner;
.field private static intemp I

;
; Runtime input scanner
;
.method static <clinit>()V

	new	java/util/Scanner
	dup
	getstatic	java/lang/System/in Ljava/io/InputStream;
	invokespecial	java/util/Scanner/<init>(Ljava/io/InputStream;)V
	putstatic	Convert/_sysin Ljava/util/Scanner;
	return

.limit locals 0
.limit stack 3
.end method

;
; Main class constructor
;
.method public <init>()V
.var 0 is this LConvert;

	aload_0
	invokespecial	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

;
; FUNCTION ctof
;
.method private static ctof(F)F

.var 2 is ctof F
.var 1 is outtemp F
.var 0 is temp F
;
; 009 outtemp=(9.0/5.0)*temp+32.0
;
	ldc	9.0
	ldc	5.0
	fdiv
	fload_0
	fmul
	ldc	32.0
	fadd
	fstore_1
;
; 010 ctof=outtemp
;
	fload_1
	fstore_2

	fload_2
	freturn

.limit locals 3
.limit stack 2
.end method

;
; FUNCTION ctok
;
.method private static ctok(F)F

.var 2 is ctok F
.var 1 is outtemp F
.var 0 is temp F
;
; 017 outtemp=temp+273
;
	fload_0
	sipush	273
	i2f
	fadd
	fstore_1
;
; 018 ctok=outtemp
;
	fload_1
	fstore_2

	fload_2
	freturn

.limit locals 3
.limit stack 2
.end method

;
; PROCEDURE print
;
.method private static print(FFF)V

.var 0 is c F
.var 1 is f F
.var 2 is k F
;
; 023 meowln(c:8:2,' in Farenheit is ',f:8:2,' and in Kelvin is ',k:8:2)
;
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"%8.2f in Farenheit is %8.2f and in Kelvin is %8.2f\n"
	iconst_3
	anewarray	java/lang/Object
	dup
	iconst_0
	fload_0
	invokestatic	java/lang/Float/valueOf(F)Ljava/lang/Float;
	aastore
	dup
	iconst_1
	fload_1
	invokestatic	java/lang/Float/valueOf(F)Ljava/lang/Float;
	aastore
	dup
	iconst_2
	fload_2
	invokestatic	java/lang/Float/valueOf(F)Ljava/lang/Float;
	aastore
	invokevirtual	java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
	pop

	return

.limit locals 3
.limit stack 8
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
; 027 furintemp=-100TO100:<<print(intemp,ctof(intemp),ctok(intemp));>>
;
	bipush	100
	ineg
	putstatic	Convert/intemp I
L001:
	getstatic	Convert/intemp I
	bipush	100
	if_icmpgt	L002
;
; 028 print(intemp,ctof(intemp),ctok(intemp))
;
	getstatic	Convert/intemp I
	i2f
	getstatic	Convert/intemp I
	i2f
	invokestatic	Convert/ctof(F)F
	getstatic	Convert/intemp I
	i2f
	invokestatic	Convert/ctok(F)F
	invokestatic	Convert/print(FFF)V
	getstatic	Convert/intemp I
	iconst_1
	iadd
	putstatic	Convert/intemp I
	goto	L001
L002:

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
