.class public TestFor
.super java/lang/Object

.field private static _sysin Ljava/util/Scanner;
.field private static ch C
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
	putstatic	TestFor/_sysin Ljava/util/Scanner;
	return

.limit locals 0
.limit stack 3
.end method

;
; Main class constructor
;
.method public <init>()V
.var 0 is this LTestFor;

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
; 008 furi=1to5:<<meowln('i = ',i)>>
;
	iconst_1
	putstatic	TestFor/i I
L001:
	getstatic	TestFor/i I
	iconst_5
	if_icmpgt	L002
;
; 009 meowln('i = ',i)
;
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"i = %d\n"
	iconst_1
	anewarray	java/lang/Object
	dup
	iconst_0
	getstatic	TestFor/i I
	invokestatic	java/lang/Integer/valueOf(I)Ljava/lang/Integer;
	aastore
	invokevirtual	java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
	pop
	getstatic	TestFor/i I
	iconst_1
	iadd
	putstatic	TestFor/i I
	goto	L001
L002:
;
; 011 meowln
;
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	invokevirtual	java/io/PrintStream.println()V
;
; 013 furi=1to3:<<furj=4downto1:<<meowln('i = ',i,', j = ',j)>>;>>
;
	iconst_1
	putstatic	TestFor/i I
L003:
	getstatic	TestFor/i I
	iconst_3
	if_icmpgt	L004
;
; 014 furj=4downto1:<<meowln('i = ',i,', j = ',j)>>
;
	iconst_4
	putstatic	TestFor/j I
L005:
	getstatic	TestFor/j I
	iconst_1
	if_icmplt	L006
;
; 015 meowln('i = ',i,', j = ',j)
;
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"i = %d, j = %d\n"
	iconst_2
	anewarray	java/lang/Object
	dup
	iconst_0
	getstatic	TestFor/i I
	invokestatic	java/lang/Integer/valueOf(I)Ljava/lang/Integer;
	aastore
	dup
	iconst_1
	getstatic	TestFor/j I
	invokestatic	java/lang/Integer/valueOf(I)Ljava/lang/Integer;
	aastore
	invokevirtual	java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
	pop
	getstatic	TestFor/j I
	iconst_m1
	iadd
	putstatic	TestFor/j I
	goto	L005
L006:
	getstatic	TestFor/i I
	iconst_1
	iadd
	putstatic	TestFor/i I
	goto	L003
L004:
;
; 019 meowln
;
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	invokevirtual	java/io/PrintStream.println()V
;
; 021 furch='a'to'z':meow(ch)
;
	bipush	97
	putstatic	TestFor/ch C
L007:
	getstatic	TestFor/ch C
	bipush	122
	if_icmpgt	L008
;
; 022 meow(ch)
;
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"%c"
	iconst_1
	anewarray	java/lang/Object
	dup
	iconst_0
	getstatic	TestFor/ch C
	invokestatic	java/lang/Character/valueOf(C)Ljava/lang/Character;
	aastore
	invokevirtual	java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
	pop
	getstatic	TestFor/ch C
	iconst_1
	iadd
	putstatic	TestFor/ch C
	goto	L007
L008:
;
; 025 meowln
;
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	invokevirtual	java/io/PrintStream.println()V
;
; 027 furch='Z'downto'A':meow(ch)
;
	bipush	90
	putstatic	TestFor/ch C
L009:
	getstatic	TestFor/ch C
	bipush	65
	if_icmplt	L010
;
; 028 meow(ch)
;
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"%c"
	iconst_1
	anewarray	java/lang/Object
	dup
	iconst_0
	getstatic	TestFor/ch C
	invokestatic	java/lang/Character/valueOf(C)Ljava/lang/Character;
	aastore
	invokevirtual	java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
	pop
	getstatic	TestFor/ch C
	iconst_m1
	iadd
	putstatic	TestFor/ch C
	goto	L009
L010:
;
; 030 meowln
;
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	invokevirtual	java/io/PrintStream.println()V

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
