.class public TestIf
.super java/lang/Object

.field private static _sysin Ljava/util/Scanner;
.field private static i I
.field private static j I
.field private static k I
.field private static p Z
.field private static q Z
.field private static str Ljava/lang/String;
.field private static txt Ljava/lang/String;
.field private static x F
.field private static y F

;
; Runtime input scanner
;
.method static <clinit>()V

	new	java/util/Scanner
	dup
	getstatic	java/lang/System/in Ljava/io/InputStream;
	invokespecial	java/util/Scanner/<init>(Ljava/io/InputStream;)V
	putstatic	TestIf/_sysin Ljava/util/Scanner;
	return

.limit locals 0
.limit stack 3
.end method

;
; Main class constructor
;
.method public <init>()V
.var 0 is this LTestIf;

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
; 010 i=1
;
	iconst_1
	putstatic	TestIf/i I
;
; 011 j=2
;
	iconst_2
	putstatic	TestIf/j I
;
; 013 ifi==jx=3.14elsex=-5
;
	getstatic	TestIf/i I
	getstatic	TestIf/j I
	if_icmpeq	L002
	iconst_0
	goto	L003
L002:
	iconst_1
L003:
	ifeq	L004
;
; 014 x=3.14
;
	ldc	3.140000104904175
	putstatic	TestIf/x F
	goto	L001
L004:
;
; 016 x=-5
;
	iconst_5
	ineg
	i2f
	putstatic	TestIf/x F
L001:
;
; 018 ifi!=jy=3.14elsey=-5
;
	getstatic	TestIf/i I
	getstatic	TestIf/j I
	if_icmpne	L006
	iconst_0
	goto	L007
L006:
	iconst_1
L007:
	ifeq	L008
;
; 019 y=3.14
;
	ldc	3.140000104904175
	putstatic	TestIf/y F
	goto	L005
L008:
;
; 021 y=-5
;
	iconst_5
	ineg
	i2f
	putstatic	TestIf/y F
L005:
;
; 023 meowln('i = ',i,', j = ',j,', x = ',x:5:2,', y = ',y:5:2)
;
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"i = %d, j = %d, x = %5.2f, y = %5.2f\n"
	iconst_4
	anewarray	java/lang/Object
	dup
	iconst_0
	getstatic	TestIf/i I
	invokestatic	java/lang/Integer/valueOf(I)Ljava/lang/Integer;
	aastore
	dup
	iconst_1
	getstatic	TestIf/j I
	invokestatic	java/lang/Integer/valueOf(I)Ljava/lang/Integer;
	aastore
	dup
	iconst_2
	getstatic	TestIf/x F
	invokestatic	java/lang/Float/valueOf(F)Ljava/lang/Float;
	aastore
	dup
	iconst_3
	getstatic	TestIf/y F
	invokestatic	java/lang/Float/valueOf(F)Ljava/lang/Float;
	aastore
	invokevirtual	java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
	pop
;
; 025 ifi==j<<x=-7>>else<<x=8>>
;
	getstatic	TestIf/i I
	getstatic	TestIf/j I
	if_icmpeq	L010
	iconst_0
	goto	L011
L010:
	iconst_1
L011:
	ifeq	L012
;
; 026 x=-7
;
	bipush	7
	ineg
	i2f
	putstatic	TestIf/x F
	goto	L009
L012:
;
; 029 x=8
;
	bipush	8
	i2f
	putstatic	TestIf/x F
L009:
;
; 032 ifi!=j<<y=14>>else<<y=-2>>
;
	getstatic	TestIf/i I
	getstatic	TestIf/j I
	if_icmpne	L014
	iconst_0
	goto	L015
L014:
	iconst_1
L015:
	ifeq	L016
;
; 033 y=14
;
	bipush	14
	i2f
	putstatic	TestIf/y F
	goto	L013
L016:
;
; 036 y=-2
;
	iconst_2
	ineg
	i2f
	putstatic	TestIf/y F
L013:
;
; 039 meowln('i = ',i,', j = ',j,', x = ',x:5:2,', y = ',y:5:2)
;
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"i = %d, j = %d, x = %5.2f, y = %5.2f\n"
	iconst_4
	anewarray	java/lang/Object
	dup
	iconst_0
	getstatic	TestIf/i I
	invokestatic	java/lang/Integer/valueOf(I)Ljava/lang/Integer;
	aastore
	dup
	iconst_1
	getstatic	TestIf/j I
	invokestatic	java/lang/Integer/valueOf(I)Ljava/lang/Integer;
	aastore
	dup
	iconst_2
	getstatic	TestIf/x F
	invokestatic	java/lang/Float/valueOf(F)Ljava/lang/Float;
	aastore
	dup
	iconst_3
	getstatic	TestIf/y F
	invokestatic	java/lang/Float/valueOf(F)Ljava/lang/Float;
	aastore
	invokevirtual	java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
	pop
;
; 041 p=i==j
;
	getstatic	TestIf/i I
	getstatic	TestIf/j I
	if_icmpeq	L017
	iconst_0
	goto	L018
L017:
	iconst_1
L018:
	putstatic	TestIf/p Z
;
; 042 ifpx=55.55else<<x=77.77;y=88.88>>
;
	getstatic	TestIf/p Z
	ifeq	L020
;
; 043 x=55.55
;
	ldc	55.54999923706055
	putstatic	TestIf/x F
	goto	L019
L020:
;
; 045 x=77.77
;
	ldc	77.7699966430664
	putstatic	TestIf/x F
;
; 046 y=88.88
;
	ldc	88.87999725341797
	putstatic	TestIf/y F
L019:
;
; 049 meowln('i = ',i,', j = ',j,', x = ',x:5:2,', y = ',y:5:2)
;
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"i = %d, j = %d, x = %5.2f, y = %5.2f\n"
	iconst_4
	anewarray	java/lang/Object
	dup
	iconst_0
	getstatic	TestIf/i I
	invokestatic	java/lang/Integer/valueOf(I)Ljava/lang/Integer;
	aastore
	dup
	iconst_1
	getstatic	TestIf/j I
	invokestatic	java/lang/Integer/valueOf(I)Ljava/lang/Integer;
	aastore
	dup
	iconst_2
	getstatic	TestIf/x F
	invokestatic	java/lang/Float/valueOf(F)Ljava/lang/Float;
	aastore
	dup
	iconst_3
	getstatic	TestIf/y F
	invokestatic	java/lang/Float/valueOf(F)Ljava/lang/Float;
	aastore
	invokevirtual	java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
	pop
;
; 051 q=i<=j
;
	getstatic	TestIf/i I
	getstatic	TestIf/j I
	if_icmple	L021
	iconst_0
	goto	L022
L021:
	iconst_1
L022:
	putstatic	TestIf/q Z
;
; 052 k=10
;
	bipush	10
	putstatic	TestIf/k I
;
; 054 ifpi=33elseifnotqi=44elseifi==ji=55elsei=6
;
	getstatic	TestIf/p Z
	ifeq	L024
;
; 055 i=33
;
	bipush	33
	putstatic	TestIf/i I
	goto	L023
L024:
;
; 056 ifnotqi=44elseifi==ji=55elsei=6
;
	getstatic	TestIf/q Z
	iconst_1
	ixor
	ifeq	L026
;
; 057 i=44
;
	bipush	44
	putstatic	TestIf/i I
	goto	L025
L026:
;
; 058 ifi==ji=55elsei=6
;
	getstatic	TestIf/i I
	getstatic	TestIf/j I
	if_icmpeq	L028
	iconst_0
	goto	L029
L028:
	iconst_1
L029:
	ifeq	L030
;
; 059 i=55
;
	bipush	55
	putstatic	TestIf/i I
	goto	L027
L030:
;
; 061 i=6
;
	bipush	6
	putstatic	TestIf/i I
L027:
L025:
L023:
;
; 064 ifnotpifqj=9elsej=-9
;
	getstatic	TestIf/p Z
	iconst_1
	ixor
	ifeq	L031
;
; 065 ifqj=9elsej=-9
;
	getstatic	TestIf/q Z
	ifeq	L033
;
; 066 j=9
;
	bipush	9
	putstatic	TestIf/j I
	goto	L032
L033:
;
; 068 j=-9
;
	bipush	9
	ineg
	putstatic	TestIf/j I
L032:
L031:
;
; 069 ifpifqk=11elsek=12
;
	getstatic	TestIf/p Z
	ifeq	L034
;
; 070 ifqk=11elsek=12
;
	getstatic	TestIf/q Z
	ifeq	L036
;
; 071 k=11
;
	bipush	11
	putstatic	TestIf/k I
	goto	L035
L036:
;
; 073 k=12
;
	bipush	12
	putstatic	TestIf/k I
L035:
L034:
;
; 075 meowln('i = ',i,', j = ',j,', x = ',x:5:2,', y = ',y:5:2)
;
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"i = %d, j = %d, x = %5.2f, y = %5.2f\n"
	iconst_4
	anewarray	java/lang/Object
	dup
	iconst_0
	getstatic	TestIf/i I
	invokestatic	java/lang/Integer/valueOf(I)Ljava/lang/Integer;
	aastore
	dup
	iconst_1
	getstatic	TestIf/j I
	invokestatic	java/lang/Integer/valueOf(I)Ljava/lang/Integer;
	aastore
	dup
	iconst_2
	getstatic	TestIf/x F
	invokestatic	java/lang/Float/valueOf(F)Ljava/lang/Float;
	aastore
	dup
	iconst_3
	getstatic	TestIf/y F
	invokestatic	java/lang/Float/valueOf(F)Ljava/lang/Float;
	aastore
	invokevirtual	java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
	pop
;
; 076 meowln('k = ',k)
;
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"k = %d\n"
	iconst_1
	anewarray	java/lang/Object
	dup
	iconst_0
	getstatic	TestIf/k I
	invokestatic	java/lang/Integer/valueOf(I)Ljava/lang/Integer;
	aastore
	invokevirtual	java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
	pop
;
; 078 meowln
;
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	invokevirtual	java/io/PrintStream.println()V
;
; 079 ifnotpandqand(i!=j)and(x<y)meow('Good-bye')
;
	getstatic	TestIf/p Z
	iconst_1
	ixor
	getstatic	TestIf/q Z
	iand
	getstatic	TestIf/i I
	getstatic	TestIf/j I
	if_icmpne	L038
	iconst_0
	goto	L039
L038:
	iconst_1
L039:
	iand
	getstatic	TestIf/x F
	getstatic	TestIf/y F
	fcmpg
	iflt	L040
	iconst_0
	goto	L041
L040:
	iconst_1
L041:
	iand
	ifeq	L037
;
; 080 meow('Good-bye')
;
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"Good-bye"
	invokevirtual	java/io/PrintStream/print(Ljava/lang/String;)V
L037:
;
; 081 ifnotpifqifi!=jifx<ymeowln(', world!')
;
	getstatic	TestIf/p Z
	iconst_1
	ixor
	ifeq	L042
;
; 082 ifqifi!=jifx<ymeowln(', world!')
;
	getstatic	TestIf/q Z
	ifeq	L043
;
; 083 ifi!=jifx<ymeowln(', world!')
;
	getstatic	TestIf/i I
	getstatic	TestIf/j I
	if_icmpne	L045
	iconst_0
	goto	L046
L045:
	iconst_1
L046:
	ifeq	L044
;
; 084 ifx<ymeowln(', world!')
;
	getstatic	TestIf/x F
	getstatic	TestIf/y F
	fcmpg
	iflt	L048
	iconst_0
	goto	L049
L048:
	iconst_1
L049:
	ifeq	L047
;
; 085 meowln(', world!')
;
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	", world!\n"
	invokevirtual	java/io/PrintStream/print(Ljava/lang/String;)V
L047:
L044:
L043:
L042:

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
