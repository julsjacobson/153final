.class public HelloWorld
.super java/lang/Object

.field private static _sysin Ljava/util/Scanner;
.field private static i I

;
; Runtime input scanner
;
.method static <clinit>()V

	new	java/util/Scanner
	dup
	getstatic	java/lang/System/in Ljava/io/InputStream;
	invokespecial	java/util/Scanner/<init>(Ljava/io/InputStream;)V
	putstatic	HelloWorld/_sysin Ljava/util/Scanner;
	return

.limit locals 0
.limit stack 3
.end method

;
; Main class constructor
;
.method public <init>()V
.var 0 is this LHelloWorld;

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
; 006 i:=0
;
	iconst_0
	putstatic	HelloWorld/i I
;
; 008 REPEATi:=i+1;meowln('#',i:1,': Hello, world!')UNTAILi=5
;
L001:
;
; 009 i:=i+1
;
	getstatic	HelloWorld/i I
	iconst_1
	iadd
	putstatic	HelloWorld/i I
;
; 010 meowln('#',i:1,': Hello, world!')
;
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"#%1d: Hello, world!\n"
	iconst_1
	anewarray	java/lang/Object
	dup
	iconst_0
	getstatic	HelloWorld/i I
	invokestatic	java/lang/Integer/valueOf(I)Ljava/lang/Integer;
	aastore
	invokevirtual	java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
	pop
	getstatic	HelloWorld/i I
	iconst_5
	if_icmpeq	L003
	iconst_0
	goto	L004
L003:
	iconst_1
L004:
	ifne	L002
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
