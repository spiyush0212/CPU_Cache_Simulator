# CPU_Cache_Simulator

CACHE PROJECT

PROBLEM STATEMENT
Write a program that allows loading into cache and searching cache using:
1. Direct Mapping
2. Fully Associative Mapping
3. K- Way Set Associative Mapping

SOLUTION
In this project, I have designed an algorithimic implementation of the cache memory using all three techniques.
Programming Language: Java

ASSUMPTIONS
The following are the assumptions:
1. The size of Main Memory, Cache Memory and Block Size should be taken in Bytes Eg: 128 Bytes, 1024 Bytes
2. The size of Main Memory, Cache Memory and Block Size is entered in power of 2 Eg; 64 Bytes, 256 Bytes
3. The number of lines in Cache is entered in power of 2. Eg; 4, 8, 16, 32
4. The size of each word is 2 Bytes 1 word = 2 bytes = 16 bits
5. The Random Cache Replacement Algorithm is applied for replacement during Fully and K- Way Set Assocoative Mapping

INPUT DATA
The following are the inputs taken from the user in the project:
1. Integer : N : Size of main memory in bytes
2. Integer : B : Size of each block in cache memory
3. Integer : CL: Number of lines in cache memory
4. Integer : K : ( Only for K- Way Set Associative Technique )
5. Integer : T : Total number of operations to be performed
6. String : PA : Physical Address to be read/written

OUTPUT
The following are part of the output of the project:
1. Information about Cache and Main Memory - size and blocks, etc
2. Displaying Cache after every operation
3. Categorizing the given PA into Tag , Block Offset, Block No, etc
4. Reading/Writing information from/onto the Cache Memory
5. Displaying Cache Hit, Miss and Ratio

GETTING STARTED
Please follow these instructions to use the Cache Memory Implementation Project:
1. Download and save the .java file on your system
2. Execute the program using an IDE
3. Follow the on-screen instructions.
4. The final result is displayed on the IDE Console

ERRORS HANDLED
The following are the errors that the Direct Mapped Cache Project:

1. ERROR: PLEASE ENTER VALID INPUT FOR MAPPING TECHNIQUE
If invalid mapping technique is selected, then this error is displayed and the program is terminated.
2. ERROR: MAIN MEMORY SIZE MUST BE LARGER THAN CACHE SIZE
If while inputting the initial values, the size of cache memory is more than main memory, then it displays this error and exits the program.
3. ERROR: NUMBER OF CACHE LINES CAN NOT BE A ODD NUMBER
4. ERROR: VALUE OF 'K' CAN NOT BE A ODD NUMBER
If while inputting the initial values, the number of cache lines or ‘K’ value is an odd number, eg, 5, 17, 33, then it displays this error and exits the program.
5. ERROR: SIZE MAIN MEMORY CAN NOT BE A ODD NUMBER
6. ERROR: SIZE OF INDIVIDUAL BLOCK CAN NOT BE A ODD NUMBER If while inputting the initial values, the size of main memory or the block size is an odd number eg, 65, 1023, then it displays this error and exits the program
7. ERROR: INPUT " + n + " MUST BE A POWER OF 2
Check if all the given values are in power of 2 or not.
8. ERROR: INVALID RESPONSE : OVERWRITING STEP ABORTED
If while overwriting data, an invalid reponse is entered. Then it aborts the overwrtiting process and moves on to the next function.
9. ERROR: BITS OF PHYSICAL ADDRESS NOT VALID
If while entering the physical address, the no. of bits are not as required. Then this error message is loaded and the program terminates.

SUPPORT
If you have any issues regarding this project, feel free to contact me.
Name: Piyush Sharma
E-Mail: piyush19316@iiitd.ac.in

UNDERSTANDING - CACHE PROJECT
The main objective behind this whole project is to design an implementation of a cache memory and highlight the technqiues of mapping. So, to thoroughly understand the project, it is important to learn/revise some theory related to the project.

CACHE MEMORY
Cache is a memory that is embedded onto the CPU chip. It acts an hardware storage for the data between RAM and CPU Chip. Cache is extremely faster than RAM, ROM and its speed is comparable to the speed of the CPU. And hence, It is embedded onto the CPU Chip. The average storage capacity of Cache is around 8 MB.

CACHE MAPPING
Cache has limited storage as compared to the RAM/ Main Memory and hence, only a limited number of blocks of main memory can be placed in the lines of the Cache Memory. Cache Mapping is this process of bringing the contents of the main memory in a systematic order and also make sure that the CPU can refer this content.
There are three types of cache mapping technique:
1. Direct Mapping 2. Fully Associative Mapping 3. K- Way Set Associative Mapping

DIRECT MAPPING
• A particular block of main memory can map to only one particular line of the cache • This relation is given by : (Block No. in main memory) modulo (Total lines in cache) • This technique is easy to implement and fast also. • It uses a lot of useless calls • It does not use the empty lines in Cache Memory to accommodate incoming blocks and hence, gives rise to conflict misses.

FULLY ASSOCIATIVE MAPPING
• A particular block of main memory can map to any line of the cache • Hence, no conflict miss and no empty lines left remaining. • This technique is harder to implement than the direct mapping and also applies one of the Replacement Algorithm of Cache Mapping • It has a lot of bits for the Tag • Since, it compares the PA with each tag. Hence, increases the number of comparsions.
Division of Physical Address in Fully Associative Mapping

K WAY SET ASSOCIATIVE MAPPING
• It is a mixture of Direct and Fully Associative Mapping • The cache lines is initally divided into sets based on a relation similar to Direct Mapping while inside each line, it follows Fully Associative Mapping. • No. Of Sets = (Total No. Of lines in Cache ) / K • The relation is given by : (Block No. in main memory) modulo (No. Of Sets) • This technique is harder to implement than the direct mapping and also applies one of the Replacement Algorithm of Cache Mapping • It decreases the number of comparsions • It uses the empty spaces more efficently than direct mapping

RESOURCES
1. YouTube – Computer Organisation and Archieture by Gate Smashers https://www.youtube.com/playlist?list=PLxCzCOWd7aiHMonh3G6QNKq53C6oNXGrX 2. GeeksForGeeks – Cache Memory and Mapping
https://www.geeksforgeeks.org/cache-memory-in-computer-organization/
3. WikiPedia – CPU Cache
https://en.wikipedia.org/wiki/CPU_cache#Direct-mapped_cache
4. GateVidyalaya - Computer Organisation and Archieture https://www.gatevidyalay.com/computer-organization-architecture/

